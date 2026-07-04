package Project.ai_workspace_platform.dto.Subscription;

public record UsageTodayResponse(
        Integer tokensUsed,
        Integer tokensLimit,
        Integer previewRunning,
        Integer previewLimit
){
}
