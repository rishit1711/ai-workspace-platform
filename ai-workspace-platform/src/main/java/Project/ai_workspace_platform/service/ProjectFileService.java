package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.Files.FileContentResponse;
import Project.ai_workspace_platform.dto.Files.FileNode;


import java.util.List;

public interface ProjectFileService {
    List<FileNode> getFileTree( Long projectId);

    FileContentResponse getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);
}
