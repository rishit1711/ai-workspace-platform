package Project.ai_workspace_platform.dto.Subscription;

public record PlanLimitResponse(
        String name,
        Integer maxTokenPerDay,
        Integer maxProjects,
        boolean unlimitedAi
) {
}
