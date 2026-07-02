package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.Files.FileNode;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {
     List<FileNode> getFileTree(Long userId, Long projectId);
}
