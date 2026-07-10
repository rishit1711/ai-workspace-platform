package Project.ai_workspace_platform.controller;

import Project.ai_workspace_platform.dto.member.InviteMemberRequest;
import Project.ai_workspace_platform.dto.member.MemberResponse;
import Project.ai_workspace_platform.dto.member.UpdateRoleRequest;
import Project.ai_workspace_platform.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {
    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getallMembers(@PathVariable Long projectId){
        Long userId=1L;
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId,userId));
    }
    @PostMapping
    public ResponseEntity<MemberResponse> addMember(@PathVariable Long projectId,@RequestBody InviteMemberRequest memberRequest){
        Long userId=1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectMemberService.addProjectMember(projectId,userId,memberRequest));
    }


    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateRole(@PathVariable Long projectId, @PathVariable Long memberId,@RequestBody UpdateRoleRequest roleRequest){

        Long userId=1L;
        return ResponseEntity.ok(projectMemberService.UpdateRoleOfMember(projectId,memberId,roleRequest,userId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long projectId, @PathVariable Long memberId){

        Long userId=1L;
        projectMemberService.DeleteMemberFromProject(projectId,memberId,userId);
        return ResponseEntity.noContent().build();
    }




}
