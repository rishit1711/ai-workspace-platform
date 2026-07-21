package Project.ai_workspace_platform.Repository;

import Project.ai_workspace_platform.entity.ProjectMember;
import Project.ai_workspace_platform.entity.ProjectMemberId;
import Project.ai_workspace_platform.enums.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {


    List<ProjectMember> findByIdProjectId(Long projectId);
    @Query(
            """
                    SELECT pm.role FROM ProjectMember pm
                    WHERE pm.id.projectId= :id
                    AND pm.id.userId= :userId
                    """
    )
    Optional<ProjectRole> findRoleByProjectIdAndUserId(@Param("projectId") Long id,@Param("userId") Long userId);
}
