package Project.ai_workspace_platform.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ChatSession {
    @EmbeddedId
    private ChatSessionId chatSessionId;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "project_id",nullable = false)
    @MapsId("projectId")
    Project project;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="user_id",nullable = false)
    @MapsId("userId")
    User user;
    @UpdateTimestamp
    Instant updatedAt;
    @CreationTimestamp
    @Column(nullable = false,unique = false)
    Instant createdAt;
    Instant deletedAt;
}
