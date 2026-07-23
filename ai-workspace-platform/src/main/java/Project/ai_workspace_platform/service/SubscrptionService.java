package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.Subscription.CheckoutRequest;
import Project.ai_workspace_platform.dto.Subscription.CheckoutResponse;
import Project.ai_workspace_platform.dto.Subscription.SubscriptionResponse;


public interface SubscrptionService {
    SubscriptionResponse getMySubscription(Long userId);

     CheckoutResponse createCheckoutResponse( CheckoutRequest checkoutRequest);
}
