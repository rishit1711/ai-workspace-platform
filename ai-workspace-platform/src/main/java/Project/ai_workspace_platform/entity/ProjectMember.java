package Project.ai_workspace_platform.entity;

import Project.ai_workspace_platform.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "project_members")
public class ProjectMember {
    @EmbeddedId
    private ProjectMemberId id;
    @ManyToOne
    @MapsId("projectId")
    private Project project;
    @ManyToOne
    @MapsId("userId")
    private User user;
    private ProjectRole role;
    private Instant invitedAt;
    private Instant acceptedAt;


}
