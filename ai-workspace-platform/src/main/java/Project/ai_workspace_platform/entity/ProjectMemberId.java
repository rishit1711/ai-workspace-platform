package Project.ai_workspace_platform.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class ProjectMemberId {
    private Long projectId;
    private Long userId;
}
