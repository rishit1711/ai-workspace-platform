package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.security.SecurityExpressions;
import Project.ai_workspace_platform.service.AIGenerationService;
import Project.ai_workspace_platform.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AIGenerationServiceImpl implements AIGenerationService {
    private final ChatClient chatClient;
    private final SecurityExpressions expressions;
    private final AuthService authService;
    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public Flux<String> streamResponse(String message, Long projectId) {

        Long userId = authService.getCurrentUserId();

        Map<String, Object> advisorParams = Map.of(
                "userId", userId,
                "projectId", projectId
        );

        createChatSessionIfNotExists(projectId, userId);

        return chatClient.prompt()
                .system("")
                .user(message)
                .advisors(advisorSpec -> advisorSpec.params(advisorParams))
                .stream()
                .chatResponse()
                .doOnNext(chatResponse -> {

                    log.info("Received chunk: {}", chatResponse.getResult().getOutput().getText());
                })
                .doOnError(error -> {
                    log.error("Error during streaming for ProjectId: {}", projectId, error);
                })
                .map(chatResponse -> chatResponse.getResult().getOutput().getText());
    }

    private void createChatSessionIfNotExists(Long projectId, Long userId) {

    }
}
