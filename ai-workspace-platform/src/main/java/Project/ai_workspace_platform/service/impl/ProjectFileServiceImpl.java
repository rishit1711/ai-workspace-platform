package Project.ai_workspace_platform.service.impl;
import Project.ai_workspace_platform.entity.Project;
import Project.ai_workspace_platform.entity.User;
import Project.ai_workspace_platform.service.ProjectFileService;
import io.minio.GetObjectArgs;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;
import Project.ai_workspace_platform.dto.Files.FileContentResponse;
import Project.ai_workspace_platform.dto.Files.FileNode;
import Project.ai_workspace_platform.entity.ProjectFile;
import Project.ai_workspace_platform.exception.ResourceNotFoundException;
import Project.ai_workspace_platform.mapper.ProjectFileMapper;
import Project.ai_workspace_platform.repository.ProjectFileRepository;
import Project.ai_workspace_platform.repository.ProjectRepository;
import Project.ai_workspace_platform.service.AuthService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectFileServiceImpl implements ProjectFileService {

    private final ProjectRepository projectRepository;
    private final ProjectFileRepository projectFileRepository;
    private final MinioClient minioClient;
    private final AuthService authService;
    private final ProjectFileMapper projectFileMapper;
    @Value("${minio.bucket-name}")
    private String bucketName;

    @Override
    public List<FileNode> getFileTree(Long projectId) {
        return projectFileMapper.toListOfFileNode(
                projectFileRepository.findByProjectId(projectId)
        );
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path) {

        ProjectFile file = projectFileRepository
                .findByProjectIdAndPath(projectId, path)
                .orElseThrow(() ->
                        new ResourceNotFoundException("File not found: " + path));

        try (InputStream inputStream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(bucketName)
                        .object(file.getMinioObjectKey())
                        .build())) {

            String content = new String(
                    inputStream.readAllBytes(),
                    StandardCharsets.UTF_8
            );

            return new FileContentResponse(
                    file.getPath(),
                    content
            );

        } catch (Exception e) {
            throw new RuntimeException("Failed to read file from MinIO", e);
        }
    }

    @Override
    @Transactional
    public void saveFile(Long projectId, String filePath, String fileContent) {

        log.info("Saving file : {}", filePath);

        User user = authService.getCurrentUser();

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

        String objectKey = "projects/" + projectId + "/" + filePath;

        byte[] bytes = fileContent.getBytes(StandardCharsets.UTF_8);

        try (InputStream inputStream = new ByteArrayInputStream(bytes)) {

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectKey)
                            .stream(inputStream, bytes.length, -1)
                            .contentType("text/plain")
                            .build()
            );

        } catch (Exception e) {
            throw new RuntimeException("Failed to save file", e);
        }

        ProjectFile projectFile = projectFileRepository
                .findByProjectIdAndPath(projectId, filePath)
                .orElse(new ProjectFile());

        projectFile.setProject(project);
        projectFile.setPath(filePath);
        projectFile.setMinioObjectKey(objectKey);
        projectFile.setFileName(Paths.get(filePath).getFileName().toString());
        projectFile.setUpdatedBy(user);

        if (projectFile.getId() == null) {
            projectFile.setCreatedBy(user);
        }

        projectFileRepository.save(projectFile);

        log.info("File saved successfully : {}", filePath);
    }
//    private String buildObjectKey(Long projectId, String filePath) {
//        return "projects/" + projectId + "/" + filePath;
//    }
}