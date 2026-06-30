package Project.ai_workspace_platform.Entity;

import java.time.Instant;

public class ChatMessage {
    Long id;
    ChatSession chatSession;
    String content;
    String toolcals;
    Integer tokenUsed;
    Instant CreatedAt;

}
