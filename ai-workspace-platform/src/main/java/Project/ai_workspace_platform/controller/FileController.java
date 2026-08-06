package Project.ai_workspace_platform.controller;

import Project.ai_workspace_platform.dto.Files.FileContentResponse;
import Project.ai_workspace_platform.dto.Files.FileNode;
import Project.ai_workspace_platform.service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/files")
@RequiredArgsConstructor
public class FileController {

    private final ProjectFileService fileService;

    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId){
        Long userId=1L;
        return ResponseEntity.ok(fileService.getFileTree(projectId));
    }
    @GetMapping("/{*path}")
    public ResponseEntity<FileContentResponse> getFileData(@PathVariable Long projectId, @RequestBody String path){
        Long userId=1L;
        return ResponseEntity.ok(fileService.getMetaData(projectId,path,userId));
    }




}
