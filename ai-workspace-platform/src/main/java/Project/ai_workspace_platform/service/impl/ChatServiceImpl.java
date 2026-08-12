package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.dto.chat.ChatResponse;
import Project.ai_workspace_platform.service.ChatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Override
    public List<ChatResponse> getProjectChatHistory(Long projectId) {
        return List.of();
    }
}
