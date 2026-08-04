package Project.ai_workspace_platform.repository;

import Project.ai_workspace_platform.entity.ProjectFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectFileRepository extends JpaRepository<ProjectFile,Long> {

    Optional<ProjectFile> findByProjectIdAndPath(Long projectId,
                                                 String filePath);



    List<ProjectFile> findByProjectId(Long projectId);
}
