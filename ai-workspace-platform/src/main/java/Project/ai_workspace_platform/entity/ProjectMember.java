package Project.ai_workspace_platform.entity;

import Project.ai_workspace_platform.enums.ProjectRole;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ProjectMember {
    private ProjectMemberId id;
    private Project project;
    private User user;
    private ProjectRole role;
    private Instant invitedAt;
    private Instant acceptedAt;


}
