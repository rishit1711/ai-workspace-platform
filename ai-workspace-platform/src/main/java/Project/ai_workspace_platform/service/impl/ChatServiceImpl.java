package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.dto.chat.ChatResponse;
import Project.ai_workspace_platform.entity.ChatSession;
import Project.ai_workspace_platform.entity.Project;
import Project.ai_workspace_platform.exception.ResourceNotFoundException;
import Project.ai_workspace_platform.mapper.ChatMapper;
import Project.ai_workspace_platform.repository.ChatMessageRepository;
import Project.ai_workspace_platform.repository.ChatSessionRepository;
import Project.ai_workspace_platform.repository.ProjectRepository;
import Project.ai_workspace_platform.security.JwtService;
import Project.ai_workspace_platform.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final ChatMessageRepository chatMessageRepository;
    private final ProjectRepository projectRepository;
    private final ChatSessionRepository chatSessionRepository;
    private final JwtService jwtService;
    private final ChatMapper chatMapper;
    @Override
    public List<ChatResponse> getProjectChatHistory(Long projectId) {
        Long userId = jwtService.getCurrentUser();
        Project project = projectRepository.findById(projectId).orElseThrow(()->new ResourceNotFoundException("Project not found"));
        if(project.getOwner().getId()!=userId){
            throw new AccessDeniedException("NOT AUTHORIZED");
        }
        ChatSession chatSession = chatSessionRepository.findByChatSessionIdProjectIdAndChatSessionIdUserId(projectId,userId);
        return chatMessageRepository.findByChatSession(chatSession)
                .stream()
                .map(chatMapper::toChatResponse)
                .toList();



    }
}
