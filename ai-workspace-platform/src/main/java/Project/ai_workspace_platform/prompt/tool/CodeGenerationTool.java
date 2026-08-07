package Project.ai_workspace_platform.prompt.tool;

import Project.ai_workspace_platform.dto.Files.FileContentResponse;
import Project.ai_workspace_platform.service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
@Slf4j
public class CodeGenerationTool {
    private final ProjectFileService projectFileService;



    @Tool(name = "read_files",
            description = "Read the content of the files in the file Tree.Do not input any path which is not present in file Tree")
    public List<FileContentResponse> getFileContent(
            Long projectId,
            @ToolParam(description = "List of relative paths . (e.g['src/App.jsx'])")
            List<String> paths
    ) {
        log.info("I want a Tool call");

        return paths.stream()
                .map(path -> projectFileService.getFileContent(projectId, path))
                .toList();
    }
}
