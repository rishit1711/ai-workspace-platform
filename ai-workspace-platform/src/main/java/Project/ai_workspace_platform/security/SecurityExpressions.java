package Project.ai_workspace_platform.security;

import Project.ai_workspace_platform.Repository.ProjectMemberRepository;
import Project.ai_workspace_platform.entity.User;
import Project.ai_workspace_platform.enums.ProjectRole;
import Project.ai_workspace_platform.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityExpressions {

    private final ProjectMemberRepository projectMemberRepository;

    public boolean canViewProject(Long id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = user.getId();

        return projectMemberRepository.findRoleByProjectIdAndUserId(id,userId)
                .map(projectRole -> projectRole.equals(ProjectRole.EDITOR) || projectRole.equals(ProjectRole.VIEWER) || projectRole.equals(ProjectRole.OWNER))
                .orElse(false);





    }
}
