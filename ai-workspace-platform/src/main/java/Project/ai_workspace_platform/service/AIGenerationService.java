package Project.ai_workspace_platform.service;

import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;

import java.util.Optional;

public interface AIGenerationService {
    Flux<String> streamResponse(String message, Long aLong);
}
