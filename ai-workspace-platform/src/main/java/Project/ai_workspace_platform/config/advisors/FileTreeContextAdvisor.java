package Project.ai_workspace_platform.config.advisors;

import Project.ai_workspace_platform.dto.Files.FileNode;
import Project.ai_workspace_platform.service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Component
@RequiredArgsConstructor

public class FileTreeContextAdvisor implements CallAdvisor {
    private final ProjectFileService projectFileService;
    @Override
    public ChatClientResponse adviseCall(ChatClientRequest request, CallAdvisorChain callAdvisorChain) {
        Map<String,Object> context = request.context();
         Long projectId =
                 (Long) request.context().get("projectId");

        ChatClientRequest augumentedChatRequest = augmentRequestWithFileTree(request,projectId);

        return callAdvisorChain.nextCall(augumentedChatRequest);
    }

    private ChatClientRequest augmentRequestWithFileTree(
            ChatClientRequest request,
            Long projectId) {

        List<FileNode> fileTree = projectFileService.getFileTree(projectId);

        String context = """
                ---- File Tree ----
                %s
                """.formatted(fileTree);

        Prompt oldPrompt = request.prompt();

        List<Message> instructions = new ArrayList<>(oldPrompt.getInstructions());

        if (!instructions.isEmpty() && instructions.get(0) instanceof SystemMessage system) {
            instructions.set(0, new SystemMessage(system.getText() + "\n" + context));
        } else {
            instructions.add(0, new SystemMessage(context));
        }

        Prompt newPrompt = new Prompt(instructions);

        return request.mutate()
                .prompt(newPrompt)
                .build();
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
