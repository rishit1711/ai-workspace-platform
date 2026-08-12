package Project.ai_workspace_platform.controller;

import Project.ai_workspace_platform.dto.chat.ChatRequest;
import Project.ai_workspace_platform.dto.chat.ChatResponse;
import Project.ai_workspace_platform.service.AIGenerationService;
import Project.ai_workspace_platform.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final AIGenerationService aiGenerationService;
    private final ChatService chatService;


    @PostMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> chat(@RequestBody ChatRequest chatRequest) {

        return aiGenerationService.streamResponse(
                chatRequest.message(),
                chatRequest.projectId()
        ).map(data -> ServerSentEvent.<String>builder()
                .data((String) data)
                .build());
    }

    @GetMapping("/projects/{projectId}")
    public List<ChatResponse> getChatHistory(@PathVariable Long projectId){
        return chatService.getProjectChatHistory(projectId);
    }

}