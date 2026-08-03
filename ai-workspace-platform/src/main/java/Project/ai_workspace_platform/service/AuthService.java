package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.Auth.AuthResponse;
import Project.ai_workspace_platform.dto.Auth.LoginRequestDto;
import Project.ai_workspace_platform.dto.Auth.SignUpRequest;
import Project.ai_workspace_platform.entity.User;


public interface AuthService {
      AuthResponse signup(SignUpRequest signUpRequest);

     AuthResponse login(LoginRequestDto loginRequest);

     Long getCurrentUserId();

    User getCurrentUser();
}
