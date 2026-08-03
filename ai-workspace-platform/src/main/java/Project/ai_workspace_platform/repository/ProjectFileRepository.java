package Project.ai_workspace_platform.repository;

import Project.ai_workspace_platform.entity.ProjectFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectFileRepository extends JpaRepository<ProjectFile,Long> {

    Optional<ProjectFile> findByProjectIdAndFilePath(Long projectId,
                                                     String filePath);

    Optional<Object> findByProjectIdAndPath(Long projectId, String filePath);
}
