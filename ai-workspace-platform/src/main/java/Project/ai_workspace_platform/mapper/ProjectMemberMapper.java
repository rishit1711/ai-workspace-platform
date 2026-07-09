package Project.ai_workspace_platform.mapper;

import Project.ai_workspace_platform.dto.member.MemberResponse;
import Project.ai_workspace_platform.entity.ProjectMember;
import Project.ai_workspace_platform.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    MemberResponse toProjectMemberResponse(User user);
     MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
