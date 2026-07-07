package Project.ai_workspace_platform.mapper;

import Project.ai_workspace_platform.dto.Auth.UserProfileResponse;
import Project.ai_workspace_platform.dto.Project.ProjectResponse;
import Project.ai_workspace_platform.dto.Project.ProjectSummaryResponse;
import Project.ai_workspace_platform.entity.Project;
import Project.ai_workspace_platform.entity.User;
import java.time.Instant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-05T13:39:03+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectResponse toProjectResponse(Project project) {
        if ( project == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        Instant createdAt = null;
        Instant updatedAt = null;
        UserProfileResponse owner = null;

        id = project.getId();
        name = project.getName();
        createdAt = project.getCreatedAt();
        updatedAt = project.getUpdatedAt();
        owner = userToUserProfileResponse( project.getOwner() );

        ProjectResponse projectResponse = new ProjectResponse( id, name, createdAt, updatedAt, owner );

        return projectResponse;
    }

    @Override
    public ProjectSummaryResponse toProjectSummaryResponse(Project project) {
        if ( project == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        Instant createdAt = null;

        id = project.getId();
        name = project.getName();
        createdAt = project.getCreatedAt();

        ProjectSummaryResponse projectSummaryResponse = new ProjectSummaryResponse( id, name, createdAt );

        return projectSummaryResponse;
    }

    protected UserProfileResponse userToUserProfileResponse(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String email = null;
        String name = null;
        String avatarUrl = null;

        id = user.getId();
        email = user.getEmail();
        name = user.getName();
        avatarUrl = user.getAvatarUrl();

        UserProfileResponse userProfileResponse = new UserProfileResponse( id, email, name, avatarUrl );

        return userProfileResponse;
    }
}
