package Project.ai_workspace_platform.entity;

import Project.ai_workspace_platform.enums.ChatEventType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "chatEvents")
public class ChatEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(nullable = false)
    ChatMessage chatMessage;
    @Column(nullable = false)
    Integer sequenceOrder;
    @Column(columnDefinition = "text")
    String content;
    @Enumerated(EnumType.STRING)
            @Column(nullable = false)
    ChatEventType eventType;
    String filePath;

}
