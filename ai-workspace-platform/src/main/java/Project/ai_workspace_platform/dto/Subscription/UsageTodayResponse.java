package Project.ai_workspace_platform.dto.Subscription;

public record UsageTodayResponse(
        int tokensUsed,
        int tokensLimit,
        int previewRunning,
        int previewLimit
){
}
