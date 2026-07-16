package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.Project.ProjectRequest;
import Project.ai_workspace_platform.dto.Project.ProjectResponse;
import Project.ai_workspace_platform.dto.Project.ProjectSummaryResponse;


import java.util.List;

public interface ProjectService {
     List<ProjectSummaryResponse> getMyProjects(Long userId);


     ProjectResponse getProjectById(Long id, Long userId);

     ProjectResponse createProject(ProjectRequest projectRequest, Long userId);

     ProjectResponse updateProject(Long id, ProjectRequest projectRequest, Long userId);

    void softDelete(Long id, Long userId);
}
