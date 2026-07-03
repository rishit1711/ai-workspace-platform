package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.Subscription.PlanResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface PlanService {

    List<PlanResponse> getAllActivePlans();
}
