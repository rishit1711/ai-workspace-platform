package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.service.AIGenerationService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
@Service
public class AIGenerationServiceImpl implements AIGenerationService {
    @Override
    public Flux<String> streamResponse(String message, Long aLong) {
        return null;
    }
}
