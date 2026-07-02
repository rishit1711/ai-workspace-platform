package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.Auth.UserProfileResponse;


public interface UserService {
     UserProfileResponse getProfile(Long id);
}
