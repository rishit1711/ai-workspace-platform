package Project.ai_workspace_platform.controller;

import Project.ai_workspace_platform.dto.chat.ChatRequest;
import Project.ai_workspace_platform.service.AIGenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final AIGenerationService aiGenerationService;


    @PostMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> chat(@RequestBody ChatRequest chatRequest) {

        return aiGenerationService.streamResponse(
                chatRequest.message(),
                chatRequest.projectId()
        ).map(data -> ServerSentEvent.<String>builder()
                .data((String) data)
                .build());
    }
}