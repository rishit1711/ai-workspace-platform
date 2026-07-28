package Project.ai_workspace_platform.entity;

import Project.ai_workspace_platform.enums.MessageRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ChatMessage {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    ChatSession chatSession;
    @Column(nullable = false)
    String content;
    @Enumerated(EnumType.STRING)
     @Column(nullable = false)
    MessageRole role;
    Integer tokenUsed;
    @CreationTimestamp
    Instant CreatedAt;

}
