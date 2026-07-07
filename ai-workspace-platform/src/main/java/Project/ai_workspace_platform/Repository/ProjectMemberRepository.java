package Project.ai_workspace_platform.Repository;

import Project.ai_workspace_platform.entity.ProjectMember;
import Project.ai_workspace_platform.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

}
