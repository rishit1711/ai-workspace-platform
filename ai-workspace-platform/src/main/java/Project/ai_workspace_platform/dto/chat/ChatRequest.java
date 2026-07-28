package Project.ai_workspace_platform.dto.chat;

public record ChatRequest(
        String message,
        Long projectId
) {
}
