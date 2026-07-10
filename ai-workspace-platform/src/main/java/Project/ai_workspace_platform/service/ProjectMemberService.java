package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.member.InviteMemberRequest;
import Project.ai_workspace_platform.dto.member.MemberResponse;
import Project.ai_workspace_platform.dto.member.UpdateRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId, Long userId);



    MemberResponse addProjectMember(Long projectId, Long userId, InviteMemberRequest memberRequest);

     MemberResponse UpdateRoleOfMember(Long projectId, Long userId, UpdateRoleRequest roleRequest, Long id);

     Void DeleteMemberFromProject(Long projectId, Long memberId, Long userId);
}
