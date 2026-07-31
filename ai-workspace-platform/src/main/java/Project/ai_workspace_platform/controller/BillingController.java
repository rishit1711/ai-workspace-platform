package Project.ai_workspace_platform.controller;

import Project.ai_workspace_platform.dto.Subscription.CheckoutRequest;
import Project.ai_workspace_platform.dto.Subscription.CheckoutResponse;
import Project.ai_workspace_platform.dto.Subscription.PlanResponse;
import Project.ai_workspace_platform.dto.Subscription.SubscriptionResponse;
import Project.ai_workspace_platform.entity.User;
import Project.ai_workspace_platform.service.PlanService;
import Project.ai_workspace_platform.service.SubscrptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BillingController {
    private final PlanService planService;
    private final SubscrptionService subscrptionService;

    @GetMapping("/api/plans")
    public ResponseEntity<List<PlanResponse>> getPlans(){

        return ResponseEntity.ok(planService.getAllActivePlans());
    }
    @GetMapping("api/me/subscription")
    public ResponseEntity<SubscriptionResponse> mySubscription(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok(subscrptionService.getMySubscription(user.getId()));
    }

    @PostMapping("/api/stripe/checkout")
    public ResponseEntity<CheckoutResponse> createCheckout(
            @RequestBody CheckoutRequest checkoutRequest
    ){


       return ResponseEntity.ok(subscrptionService.createCheckoutResponse(checkoutRequest));


    }


}
