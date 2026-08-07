package Project.ai_workspace_platform.llm.tool;

import Project.ai_workspace_platform.dto.Files.FileContentResponse;
import Project.ai_workspace_platform.service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class CodeGenerationTool {
    private final ProjectFileService projectFileService;


    @Tool
    public List<FileContentResponse> getFileContent(
            Long projectId,
            List<String> paths
    ) {

        return paths.stream()
                .map(path -> projectFileService.getFileContent(projectId, path))
                .toList();
    }
}
