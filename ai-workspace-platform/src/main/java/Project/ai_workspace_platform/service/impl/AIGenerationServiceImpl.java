package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.security.SecurityExpressions;
import Project.ai_workspace_platform.service.AIGenerationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
@Service
@RequiredArgsConstructor
@Slf4j
public class AIGenerationServiceImpl implements AIGenerationService {
    private final ChatClient chatClient;
    private final SecurityExpressions expressions;
    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public Flux<String> streamResponse(String message, Long projectId) {
        return null;
    }
}
