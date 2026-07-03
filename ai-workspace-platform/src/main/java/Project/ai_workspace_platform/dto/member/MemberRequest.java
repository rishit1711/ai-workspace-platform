package Project.ai_workspace_platform.dto.member;

import Project.ai_workspace_platform.enums.ProjectRole;

public record MemberRequest(
        String email,
        ProjectRole role
) {
}
