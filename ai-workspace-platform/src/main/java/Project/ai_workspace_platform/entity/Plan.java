package Project.ai_workspace_platform.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plan {
    private Long id;
    private String name;
    private String stripePriceId;
    private Integer maxProjects;
    private Integer MaxTokensPerDay;
    private Integer maxPreviews;
    private Boolean UnlimitedAI;
    private Boolean isActive;

}
