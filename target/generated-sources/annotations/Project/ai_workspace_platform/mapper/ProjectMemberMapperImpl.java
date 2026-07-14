package Project.ai_workspace_platform.mapper;

import Project.ai_workspace_platform.dto.member.MemberResponse;
import Project.ai_workspace_platform.entity.ProjectMember;
import Project.ai_workspace_platform.entity.ProjectMemberId;
import Project.ai_workspace_platform.entity.User;
import Project.ai_workspace_platform.enums.ProjectRole;
import java.time.Instant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-14T18:56:07+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class ProjectMemberMapperImpl implements ProjectMemberMapper {

    @Override
    public MemberResponse toProjectMemberResponse(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String email = null;
        String name = null;
        String avatarUrl = null;

        id = user.getId();
        email = user.getEmail();
        name = user.getName();
        avatarUrl = user.getAvatarUrl();

        ProjectRole projectRole = null;
        Instant invitedAt = null;

        MemberResponse memberResponse = new MemberResponse( id, email, name, avatarUrl, projectRole, invitedAt );

        return memberResponse;
    }

    @Override
    public MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember) {
        if ( projectMember == null ) {
            return null;
        }

        Long id = null;
        String email = null;
        String name = null;
        String avatarUrl = null;
        ProjectRole projectRole = null;
        Instant invitedAt = null;

        id = projectMemberIdUserId( projectMember );
        email = projectMemberUserEmail( projectMember );
        name = projectMemberUserName( projectMember );
        avatarUrl = projectMemberUserAvatarUrl( projectMember );
        projectRole = projectMember.getRole();
        invitedAt = projectMember.getInvitedAt();

        MemberResponse memberResponse = new MemberResponse( id, email, name, avatarUrl, projectRole, invitedAt );

        return memberResponse;
    }

    private Long projectMemberIdUserId(ProjectMember projectMember) {
        ProjectMemberId id = projectMember.getId();
        if ( id == null ) {
            return null;
        }
        return id.getUserId();
    }

    private String projectMemberUserEmail(ProjectMember projectMember) {
        User user = projectMember.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getEmail();
    }

    private String projectMemberUserName(ProjectMember projectMember) {
        User user = projectMember.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getName();
    }

    private String projectMemberUserAvatarUrl(ProjectMember projectMember) {
        User user = projectMember.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getAvatarUrl();
    }
}
