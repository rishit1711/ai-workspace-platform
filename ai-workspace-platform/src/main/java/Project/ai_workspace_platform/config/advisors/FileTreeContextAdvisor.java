package Project.ai_workspace_platform.config.advisors;

import okhttp3.Call;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;

public class FileTreeContextAdvisor implements CallAdvisor {
    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
