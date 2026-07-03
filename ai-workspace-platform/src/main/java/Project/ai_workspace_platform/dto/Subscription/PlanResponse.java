package Project.ai_workspace_platform.dto.Subscription;

public record PlanResponse(
        String name,
         String stripePriceId,
         Integer maxProjects,
         Integer MaxTokensPerDay,
         Integer maxPreviews,
         Boolean UnlimitedAI,
         Boolean isActive
) {
}
