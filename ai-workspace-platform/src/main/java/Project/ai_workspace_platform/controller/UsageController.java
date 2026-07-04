package Project.ai_workspace_platform.controller;

import Project.ai_workspace_platform.dto.Subscription.PlanLimitResponse;
import Project.ai_workspace_platform.dto.Subscription.UsageTodayResponse;
import Project.ai_workspace_platform.service.UsageService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usage")
public class UsageController {

    private final UsageService usageService;

    @GetMapping("/today")
    public ResponseEntity<UsageTodayResponse> getUsage(){
        Long userId=1L;
        return ResponseEntity.ok(usageService.getTodayUsage(userId));
    }
    @GetMapping("/limits")
    public ResponseEntity<PlanLimitResponse>  getLimits(){
        Long userId=1L;
        return ResponseEntity.ok(usageService.getCurrentSubscriptionLimitOfUser(userId));
    }


}
