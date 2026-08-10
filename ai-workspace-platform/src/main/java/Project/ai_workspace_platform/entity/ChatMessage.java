package Project.ai_workspace_platform.entity;

import Project.ai_workspace_platform.enums.MessageRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

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
    @OneToMany(mappedBy = "chatMessage",cascade = CascadeType.ALL)
    List<ChatEvent> chatEventList;
    @Enumerated(EnumType.STRING)
     @Column(nullable = false)
    MessageRole role;
    Integer tokenUsed;
    @CreationTimestamp
    Instant CreatedAt;

}
