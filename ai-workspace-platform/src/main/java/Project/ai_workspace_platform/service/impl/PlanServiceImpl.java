package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.dto.Subscription.PlanResponse;
import Project.ai_workspace_platform.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
