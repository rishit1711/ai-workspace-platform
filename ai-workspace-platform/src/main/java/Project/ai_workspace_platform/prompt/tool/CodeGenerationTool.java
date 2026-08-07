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



    @Tool(
            name = "read_files",
            description = """
Returns the latest contents of one or more existing project files.

IMPORTANT:
- You DO NOT know the contents of any existing project file.
- Before modifying ANY existing file, you MUST call this tool.
- Never guess or reconstruct file contents from memory.
- The returned contents are the only source of truth.
- Call this tool only for files that exist in the provided project tree.
"""
    )
    public List<FileContentResponse> getFileContent(
            Long projectId,
            @ToolParam(
                    description = """
List of existing project file paths to read.

Example:
[
  "src/App.tsx",
  "src/components/Navbar.tsx"
]

Only include files that already exist in the project tree.
"""
            )
            List<String> paths
    ) {
        log.info("I want a Tool call");

        return paths.stream()
                .map(path -> projectFileService.getFileContent(projectId, path))
                .toList();
    }
}
