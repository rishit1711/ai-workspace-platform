package Project.ai_workspace_platform.Repository;

import Project.ai_workspace_platform.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    @Query("""
    SELECT p
    FROM Project p
    JOIN ProjectMember pm
        ON pm.project = p
    WHERE p.deletedAt IS NULL
    AND pm.user.id = :userId
    ORDER BY p.updatedAt DESC
    """)
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);

    @Query("""
    SELECT DISTINCT p
    FROM Project p
    JOIN FETCH p.owner
    JOIN ProjectMember pm
        ON pm.project = p
    WHERE p.id = :projectId
    AND p.deletedAt IS NULL
    AND pm.user.id = :userId
    """)

    Optional<Project> findAccessibleProjectById(@Param("projectId")Long projectId,
                                                @Param("userId") Long userId);

}
