package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.dto.Subscription.PlanLimitResponse;
import Project.ai_workspace_platform.dto.Subscription.UsageTodayResponse;
import Project.ai_workspace_platform.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {

    @Override
    public UsageTodayResponse getTodayUsage(Long userId) {
        return null;
    }

    @Override
    public PlanLimitResponse getCurrentSubscriptionLimitOfUser(Long userId) {
        return null;
    }
}
