package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.dto.member.MemberRequest;
import Project.ai_workspace_platform.dto.member.MemberResponse;
import Project.ai_workspace_platform.dto.member.UpdateRoleRequest;
import Project.ai_workspace_platform.service.ProjectMemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponse addProjectMember(Long projectId, Long userId, MemberRequest memberRequest) {
        return null;
    }

    @Override
    public MemberResponse UpdateRoleOfMember(Long projectId, Long userId, UpdateRoleRequest roleRequest, Long id) {
        return null;
    }

    @Override
    public Void DeleteMemberFromProject(Long projectId, Long memberId, Long userId) {
        return null;
    }
}
