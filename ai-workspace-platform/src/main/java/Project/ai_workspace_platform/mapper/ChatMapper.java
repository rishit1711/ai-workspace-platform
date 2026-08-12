package Project.ai_workspace_platform.mapper;

import Project.ai_workspace_platform.dto.chat.ChatResponse;
import Project.ai_workspace_platform.entity.ChatMessage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    ChatResponse toChatResponse(ChatMessage chatMessage);
}
