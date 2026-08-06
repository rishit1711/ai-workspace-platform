package Project.ai_workspace_platform.config.advisors;

import okhttp3.Call;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;

import java.util.Map;

public class FileTreeContextAdvisor implements CallAdvisor {
    @Override
    public ChatClientResponse adviseCall(ChatClientRequest request, CallAdvisorChain callAdvisorChain) {
        Map<String,Object> context = request.context();
        Long projectId= Long.parseLong((String) context.getOrDefault("projectId",0));

        ChatClientRequest augumentedchatRequest = augumentRequestWithFileTree(request,projectId);

        return callAdvisorChain.nextCall(augumentedchatRequest);
    }

    private ChatClientRequest augumentRequestWithFileTree(ChatClientRequest request,Long projectId){

    }

    @Override
    public String getName() {
        return "FileTreeContextAdvisor";
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
