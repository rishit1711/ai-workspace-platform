package Project.ai_workspace_platform.dto.Project;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Instant createdAt
) {
}
