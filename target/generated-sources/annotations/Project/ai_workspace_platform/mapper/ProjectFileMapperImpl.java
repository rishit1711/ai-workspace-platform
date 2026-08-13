package Project.ai_workspace_platform.mapper;

import Project.ai_workspace_platform.dto.Files.FileNode;
import Project.ai_workspace_platform.entity.ProjectFile;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-13T18:58:19+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class ProjectFileMapperImpl implements ProjectFileMapper {

    @Override
    public List<FileNode> toListOfFileNode(List<ProjectFile> projectFileList) {
        if ( projectFileList == null ) {
            return null;
        }

        List<FileNode> list = new ArrayList<FileNode>( projectFileList.size() );
        for ( ProjectFile projectFile : projectFileList ) {
            list.add( projectFileToFileNode( projectFile ) );
        }

        return list;
    }

    protected FileNode projectFileToFileNode(ProjectFile projectFile) {
        if ( projectFile == null ) {
            return null;
        }

        String path = null;

        path = projectFile.getPath();

        FileNode fileNode = new FileNode( path );

        return fileNode;
    }
}
