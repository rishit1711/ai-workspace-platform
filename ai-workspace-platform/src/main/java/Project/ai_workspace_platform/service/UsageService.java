package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.Subscription.PlanLimitResponse;
import Project.ai_workspace_platform.dto.Subscription.UsageTodayResponse;
import org.springframework.http.ProblemDetail;

public interface UsageService {
    UsageTodayResponse getTodayUsage(Long userId);

    PlanLimitResponse getCurrentSubscriptionLimitOfUser(Long userId);
}
