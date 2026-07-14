package Project.ai_workspace_platform.dto.Project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProjectRequest(
       @NotBlank  String name

) {
}
