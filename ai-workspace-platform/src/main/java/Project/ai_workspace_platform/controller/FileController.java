package Project.ai_workspace_platform.controller;

import Project.ai_workspace_platform.dto.Files.FileContentResponse;
import Project.ai_workspace_platform.dto.Files.FileNode;
import Project.ai_workspace_platform.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId){
        Long userId=1L;
        return ResponseEntity.ok(fileService.getFileTree(userId,projectId));
    }
    @GetMapping("/{*path}")
    public ResponseEntity<FileContentResponse> getFileData(@PathVariable Long projectId, @RequestBody String path){
        Long userId=1L;
        return ResponseEntity.ok(fileService.getMetaData(projectId,path,userId));
    }




}
