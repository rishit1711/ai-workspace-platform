package Project.ai_workspace_platform.dto.member;

import Project.ai_workspace_platform.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email
        @NotBlank
        String email,
        @NotNull
        ProjectRole role
) {
}
