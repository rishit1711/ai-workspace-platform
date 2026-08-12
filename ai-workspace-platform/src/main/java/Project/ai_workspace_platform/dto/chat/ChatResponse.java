package Project.ai_workspace_platform.dto.chat;

import Project.ai_workspace_platform.entity.ChatEvent;
import Project.ai_workspace_platform.enums.MessageRole;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

public record ChatResponse(

        Long id,

        String content,

        List<ChatEvent> chatEventList,


        MessageRole role,
        Integer tokenUsed,

         Instant CreatedAt

) {
}
