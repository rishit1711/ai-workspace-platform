package Project.ai_workspace_platform.mapper;

import Project.ai_workspace_platform.dto.member.MemberResponse;
import Project.ai_workspace_platform.entity.ProjectMember;
import Project.ai_workspace_platform.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "projectRole", ignore = true)
    MemberResponse toProjectMemberResponse(User user);

    @Mapping(source = "id.userId", target = "id")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.avatarUrl", target = "avatarUrl")
    @Mapping(source = "role", target = "projectRole")
    @Mapping(source = "invitedAt", target = "invitedAt")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}