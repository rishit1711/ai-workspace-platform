package Project.ai_workspace_platform.Entity;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Getter
@Setter

public class Subscription {
    private Long id;
    private User user;
    private Plan plan;
    private String stripeCustomerId;
    private String stripeSubscriptionId;
    private Instant currentPeriodStart;
    private Instant currentPeriodEnd;
    private Boolean cancelAtPeriodEnd;
    private Instant createdAt;
    private Instant updatedAt;


}
