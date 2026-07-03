package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.Files.FileContentResponse;
import Project.ai_workspace_platform.dto.Files.FileNode;


import java.util.List;

public interface FileService {
     List<FileNode> getFileTree(Long userId, Long projectId);

    FileContentResponse getMetaData(Long projectId, String path, Long userId);
}
