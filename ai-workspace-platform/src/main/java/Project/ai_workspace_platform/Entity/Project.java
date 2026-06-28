package Project.ai_workspace_platform.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Project {

    private Long id;
    private String name;
    private User owner;
    private Boolean isPublic;
    private Instant createdAt;
    private Instant deletedAt;
    private Instant updatedAt;

}
