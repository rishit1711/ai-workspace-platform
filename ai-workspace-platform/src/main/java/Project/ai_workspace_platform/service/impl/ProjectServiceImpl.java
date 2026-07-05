package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.Repository.ProjectRepository;
import Project.ai_workspace_platform.Repository.UserRepository;
import Project.ai_workspace_platform.dto.Project.ProjectRequest;
import Project.ai_workspace_platform.dto.Project.ProjectResponse;
import Project.ai_workspace_platform.dto.Project.ProjectSummaryResponse;
import Project.ai_workspace_platform.entity.Project;
import Project.ai_workspace_platform.entity.User;
import Project.ai_workspace_platform.mapper.ProjectMapper;
import Project.ai_workspace_platform.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;

    @Override
    public List<ProjectSummaryResponse> getMyProjects(Long userId) {
        return List.of();
    }

    @Override
    public ProjectResponse getProjectMyId(Long id, Long userId) {
        return null;
    }

    @Override

    public ProjectResponse createProject(ProjectRequest projectRequest, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Not Found"));
         Project project = Project.builder()
                         .name(projectRequest.name())
                                 .owner(owner)
                 .build();

         projectRepository.save(project);
         return projectMapper.toProjectResponse(project);

    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest projectRequest, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
