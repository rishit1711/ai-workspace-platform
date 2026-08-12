package Project.ai_workspace_platform.repository;

import Project.ai_workspace_platform.entity.ChatSession;
import Project.ai_workspace_platform.entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {


    ChatSession findByChatSessionIdProjectIdAndChatSessionIdUserId(
            Long projectId,
            Long userId
    );
}
