package Project.ai_workspace_platform.controller;

import Project.ai_workspace_platform.dto.Project.ProjectRequest;
import Project.ai_workspace_platform.dto.Project.ProjectResponse;
import Project.ai_workspace_platform.dto.Project.ProjectSummaryResponse;
import Project.ai_workspace_platform.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;


    @GetMapping
    public ResponseEntity<List<ProjectSummaryResponse>> getprojects(){
        Long userId = 1L;   // later spring security se current logged-in user mil jayega
        return ResponseEntity.ok(projectService.getMyProjects(userId));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProject(@PathVariable Long id){
        Long userId=1L;
        return ResponseEntity.ok(projectService.getProjectById(id,userId));
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody @Valid ProjectRequest projectRequest){

        Long userId=1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(projectRequest,userId));

    }
    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id,@RequestBody @Valid ProjectRequest projectRequest){
        Long userId=1L;
        return ResponseEntity.ok(projectService.updateProject(id,projectRequest,userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        Long userId=1L;
        projectService.softDelete(id,userId);
        return ResponseEntity.noContent().build();

    }




}
