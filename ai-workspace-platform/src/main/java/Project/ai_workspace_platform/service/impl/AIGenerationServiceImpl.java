package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.config.advisors.FileTreeContextAdvisor;
import Project.ai_workspace_platform.llm.SystemPrompt;
import Project.ai_workspace_platform.security.SecurityExpressions;
import Project.ai_workspace_platform.service.AIGenerationService;
import Project.ai_workspace_platform.service.AuthService;
import Project.ai_workspace_platform.service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

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
    private final FileTreeContextAdvisor fileTreeContextAdvisor;

    private static final Pattern FILE_PATTERN = Pattern.compile(
            "<file>\\s*<path>(.*?)</path>\\s*<content><!\\[CDATA\\[(.*?)]]></content>\\s*</file>",
            Pattern.DOTALL
    );

    //@PreAuthorize("@security.canViewProject(#projectId)")
    @Override
    public Flux<String> streamResponse(String message, Long projectId) {

        Long userId = authService.getCurrentUserId();

        Map<String, Object> advisorParams = Map.of(
                "userId", userId,
                "projectId", projectId
        );

        createChatSessionIfNotExists(projectId, userId);

        ChatResponse response = chatClient.prompt()
                .system(SystemPrompt.CODE_GENERATION_SYSTEM_PROMPT)
                .user(message)
                        .advisors(advisorSpec -> {
                            advisorSpec.advisors(fileTreeContextAdvisor);
                            advisorSpec.params(advisorParams);
                        })

                .call()
                .chatResponse();

        String content = response.getResult().getOutput().getText();

        parseAndSaveFiles(content, projectId);

        return Flux.just(content);
    }
    private void parseAndSaveFiles(String fullResponse, Long projectId) {
        log.info("Full response:\n{}", fullResponse);
        Matcher matcher = FILE_PATTERN.matcher(fullResponse);

        while (matcher.find()) {
            String filePath = matcher.group(1).trim();
            String fileContent = matcher.group(2);

            log.info("Saving {}", filePath);

            projectFileService.saveFile(projectId, filePath, fileContent);
        }
    }

    private void createChatSessionIfNotExists(Long projectId, Long userId) {

    }
}
