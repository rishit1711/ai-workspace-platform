package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.security.SecurityExpressions;
import Project.ai_workspace_platform.service.AIGenerationService;
import Project.ai_workspace_platform.service.AuthService;
import Project.ai_workspace_platform.service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Slf4j
public class AIGenerationServiceImpl implements AIGenerationService {
    private final ChatClient chatClient;
    private final SecurityExpressions expressions;
    private final AuthService authService;
    private final ProjectFileService projectFileService;

     private static final Pattern FILE_PATTERN = Pattern.compile(
            "<file\\s+path=\"([^\"]+)\">(.*?)</file>",
            Pattern.DOTALL
    );
    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public Flux<String> streamResponse(String message, Long projectId) {

        Long userId = authService.getCurrentUserId();

        Map<String, Object> advisorParams = Map.of(
                "userId", userId,
                "projectId", projectId
        );

        createChatSessionIfNotExists(projectId, userId);
        StringBuilder buffer = new StringBuilder();

        return chatClient.prompt()
                .system("")
                .user(message)
                .advisors(advisorSpec -> advisorSpec.params(advisorParams))
                .stream()
                .chatResponse()
                .doOnNext(chatResponse -> {
                    String content=chatResponse.getResult().getOutput().getText();
                    buffer.append(content);
                })
                .doOnComplete(()->{
                    Schedulers.boundedElastic().schedule(()->{
                        parseAndSaveFiles(buffer.toString(),projectId);
                    });

                })
                .doOnError(error -> {
                    log.error("Error during streaming for ProjectId: {}", projectId, error);
                })
                .map(chatResponse -> chatResponse.getResult().getOutput().getText());
    }

    private void parseAndSaveFiles(String fullResponse, Long projectId) {
        Matcher matcher=FILE_PATTERN.matcher(fullResponse);
        while (matcher.find()){
            String filePath=matcher.group(1);
            String fileContent = matcher.group(2).trim();
        }
    }

    private void createChatSessionIfNotExists(Long projectId, Long userId) {

    }
}
