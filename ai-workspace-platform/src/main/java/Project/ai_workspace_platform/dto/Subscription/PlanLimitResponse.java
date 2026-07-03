package Project.ai_workspace_platform.dto.Subscription;

public record PlanLimitResponse(
        String name,
        int maxTokenPerDay,
        int maxProjects,
        boolean unlimitedAi
) {
}
