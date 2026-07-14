package Project.ai_workspace_platform.dto.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpRequest(

        @Size(min=4,max = 50)  String name,
        @Email @NotBlank String email,
        @Size(min = 4) String password
) {
}
