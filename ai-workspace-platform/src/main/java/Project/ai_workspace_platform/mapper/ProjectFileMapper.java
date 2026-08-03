package Project.ai_workspace_platform.mapper;

import Project.ai_workspace_platform.dto.Files.FileNode;
import Project.ai_workspace_platform.entity.ProjectFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectFileMapper {
    List<FileNode> toListOfFileNode(List<ProjectFile> projectFileList);
}
