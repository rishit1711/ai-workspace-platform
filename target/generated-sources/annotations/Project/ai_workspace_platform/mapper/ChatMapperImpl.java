package Project.ai_workspace_platform.mapper;

import Project.ai_workspace_platform.dto.chat.ChatResponse;
import Project.ai_workspace_platform.entity.ChatEvent;
import Project.ai_workspace_platform.entity.ChatMessage;
import Project.ai_workspace_platform.enums.MessageRole;
import java.time.Instant;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-13T18:58:19+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class ChatMapperImpl implements ChatMapper {

    @Override
    public ChatResponse toChatResponse(ChatMessage chatMessage) {
        if ( chatMessage == null ) {
            return null;
        }

        Long id = null;
        String content = null;
        MessageRole role = null;
        Integer tokenUsed = null;

        id = chatMessage.getId();
        content = chatMessage.getContent();
        role = chatMessage.getRole();
        tokenUsed = chatMessage.getTokenUsed();

        List<ChatEvent> chatEventList = null;
        Instant createdAt = null;

        ChatResponse chatResponse = new ChatResponse( id, content, chatEventList, role, tokenUsed, createdAt );

        return chatResponse;
    }
}
