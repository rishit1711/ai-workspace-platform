package Project.ai_workspace_platform.Repository;

import Project.ai_workspace_platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
