package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.Repository.ProjectMemberRepository;
import Project.ai_workspace_platform.Repository.ProjectRepository;
import Project.ai_workspace_platform.dto.member.MemberRequest;
import Project.ai_workspace_platform.dto.member.MemberResponse;
import Project.ai_workspace_platform.dto.member.UpdateRoleRequest;
import Project.ai_workspace_platform.entity.Project;
import Project.ai_workspace_platform.entity.ProjectMember;
import Project.ai_workspace_platform.entity.User;
import Project.ai_workspace_platform.mapper.ProjectMemberMapper;
import Project.ai_workspace_platform.service.ProjectMemberService;
import Project.ai_workspace_platform.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;
    private final ProjectMemberMapper projectMemberMapper;
    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();
        List<MemberResponse> memberResponseList = new ArrayList<>();
        memberResponseList.add(projectMemberMapper.toProjectMemberResponse(project.getOwner()));
        memberResponseList.addAll(
                projectMemberRepository.findByIdProjectId(projectId)
                        .stream()
                        .map(projectMember -> projectMemberMapper.toProjectMemberResponseFromMember(projectMember))
                        .collect(Collectors.toList()));






        return memberResponseList;
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
