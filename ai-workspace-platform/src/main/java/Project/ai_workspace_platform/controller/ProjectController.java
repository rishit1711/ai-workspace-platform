package Project.ai_workspace_platform.controller;

import Project.ai_workspace_platform.dto.Project.ProjectRequest;
import Project.ai_workspace_platform.dto.Project.ProjectResponse;
import Project.ai_workspace_platform.dto.Project.ProjectSummaryResponse;
import Project.ai_workspace_platform.entity.User;
import Project.ai_workspace_platform.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;


    @GetMapping
    public ResponseEntity<List<ProjectSummaryResponse>> getProjects(){
        User user = getUser();
        return ResponseEntity.ok(projectService.getMyProjects(user.getId()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProject(@PathVariable Long id){
        User user = getUser();
        return ResponseEntity.ok(projectService.getProjectById(id, user.getId()));
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody @Valid ProjectRequest projectRequest){

        User user = getUser();
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(projectRequest, user.getId()));

    }
    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id,@RequestBody @Valid ProjectRequest projectRequest){
        User user = getUser();
        return ResponseEntity.ok(projectService.updateProject(id,projectRequest,user.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        User user = getUser();
        projectService.softDelete(id, user.getId());
        return ResponseEntity.noContent().build();

    }

    public User getUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }




}
