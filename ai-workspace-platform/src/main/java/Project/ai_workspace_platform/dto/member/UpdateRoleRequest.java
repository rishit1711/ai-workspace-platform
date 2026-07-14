package Project.ai_workspace_platform.dto.member;

import Project.ai_workspace_platform.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateRoleRequest(@NotNull ProjectRole role) {
}
