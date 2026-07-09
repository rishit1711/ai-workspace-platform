package Project.ai_workspace_platform.entity;

import Project.ai_workspace_platform.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
    @MapsId("projectId")   // ek entity ki primary key dursi entity ki primary key se hi derive hoti hai
    private Project project;
    @ManyToOne
    @MapsId("userId")
    private User user;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectRole role;

    private Instant invitedAt;
    private Instant acceptedAt;


}
