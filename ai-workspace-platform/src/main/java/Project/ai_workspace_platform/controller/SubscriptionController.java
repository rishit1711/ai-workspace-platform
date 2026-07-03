package Project.ai_workspace_platform.controller;

import Project.ai_workspace_platform.dto.Subscription.PlanResponse;
import Project.ai_workspace_platform.service.PlanService;
import Project.ai_workspace_platform.service.SubscrptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SubscriptionController {
    private final PlanService planService;
    private final SubscrptionService subscrptionService;

    @GetMapping("/api/plans")
    public ResponseEntity<List<PlanResponse>> getPlans(){
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

}
