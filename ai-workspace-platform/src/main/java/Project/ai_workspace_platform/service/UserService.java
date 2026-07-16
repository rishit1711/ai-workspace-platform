package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.Auth.UserProfileResponse;
import Project.ai_workspace_platform.entity.User;


public interface UserService {
     UserProfileResponse getProfile(Long id);
     User getUserById(Long id);
}
