package Project.ai_workspace_platform.dto.Auth;

public record SignUpRequest(
        String name,
        String email,
        String password
) {
}
