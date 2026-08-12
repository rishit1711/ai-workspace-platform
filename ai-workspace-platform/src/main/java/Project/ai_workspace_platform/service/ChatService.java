package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.chat.ChatResponse;

import java.util.List;

public interface ChatService {
    List<ChatResponse> getProjectChatHistory(Long projectId);

}
