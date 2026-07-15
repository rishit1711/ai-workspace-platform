package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.Auth.AuthResponse;
import Project.ai_workspace_platform.dto.Auth.LoginRequestDto;
import Project.ai_workspace_platform.dto.Auth.SignUpRequest;


public interface AuthService {
      AuthResponse signup(SignUpRequest signUpRequest);

     AuthResponse login(LoginRequestDto loginRequest);
}
