package Project.ai_workspace_platform.dto.Project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
       @NotBlank String name

) {
}
