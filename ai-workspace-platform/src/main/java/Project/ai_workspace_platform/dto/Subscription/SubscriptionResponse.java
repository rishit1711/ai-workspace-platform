package Project.ai_workspace_platform.dto.Subscription;

import Project.ai_workspace_platform.enums.SubscriptionStatus;

import java.time.Instant;

public record SubscriptionResponse(

        PlanResponse  plan,
        SubscriptionStatus status,
        Instant periodEnd,
        Long tokenUsed
) {
}
