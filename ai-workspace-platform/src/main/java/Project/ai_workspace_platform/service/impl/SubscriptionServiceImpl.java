package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.dto.Subscription.CheckoutRequest;
import Project.ai_workspace_platform.dto.Subscription.CheckoutResponse;
import Project.ai_workspace_platform.dto.Subscription.SubscriptionResponse;
import Project.ai_workspace_platform.service.SubscrptionService;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscrptionService {
    @Override
    public SubscriptionResponse getMySubscription(Long userId) {
        return null;
    }

    @Override
    public @Nullable CheckoutResponse createCheckoutResponse(Long userId, CheckoutRequest checkoutRequest) {
        return null;
    }
}
