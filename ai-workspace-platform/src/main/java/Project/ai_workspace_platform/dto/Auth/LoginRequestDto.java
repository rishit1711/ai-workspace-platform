package Project.ai_workspace_platform.dto.Auth;

import jakarta.validation.constraints.*;

public record LoginRequestDto(
        @Email
        @NotBlank
        String email,
        @NotNull
        @Size(min = 4,max = 20)
        String password
) {
}
