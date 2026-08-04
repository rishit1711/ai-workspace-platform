package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.entity.ProjectFile;
import Project.ai_workspace_platform.entity.User;
import Project.ai_workspace_platform.mapper.ProjectFileMapper;
import Project.ai_workspace_platform.repository.ProjectFileRepository;
import Project.ai_workspace_platform.repository.ProjectRepository;
import Project.ai_workspace_platform.dto.Files.FileContentResponse;
import Project.ai_workspace_platform.dto.Files.FileNode;
import Project.ai_workspace_platform.entity.Project;
import Project.ai_workspace_platform.exception.ResourceNotFoundException;
import Project.ai_workspace_platform.service.AuthService;
import Project.ai_workspace_platform.service.ProjectFileService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

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
    public List<FileNode> getFileTree(Long userId, Long projectId) {
        List<ProjectFile> projectFileList = projectFileRepository.findByProjectId(projectId);

        return projectFileMapper.toListOfFileNode(projectFileList);
    }

    @Override
    public FileContentResponse getMetaData(Long projectId, String path, Long userId) {
        return null;
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

        ProjectFile projectFile = (ProjectFile) projectFileRepository
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
}
