package Project.ai_workspace_platform.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
        indexes = {
                @Index(
                        name = "idx_project_owner_created",
                        columnList = "owner_id, created_at"
                ),
                @Index(
                        name = "idx_project_public",
                        columnList = "is_public"
                ),
                @Index(
                        name = "idx_project_deleted",
                        columnList = "deleted_at"
                )
        }
)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    private Boolean isPublic = false;

    @CreationTimestamp
    private Instant createdAt;

    private Instant deletedAt;

    @UpdateTimestamp
    private Instant updatedAt;
}