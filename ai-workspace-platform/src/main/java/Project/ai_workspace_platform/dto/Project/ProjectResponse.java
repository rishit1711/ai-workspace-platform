package Project.ai_workspace_platform.dto.Project;

import Project.ai_workspace_platform.dto.Auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(

        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner

) {
}
