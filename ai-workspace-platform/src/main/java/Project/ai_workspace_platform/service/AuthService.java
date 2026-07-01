package Project.ai_workspace_platform.service;

import Project.ai_workspace_platform.dto.Auth.AuthResponseDto;
import Project.ai_workspace_platform.dto.Auth.LoginRequestDto;
import Project.ai_workspace_platform.dto.Auth.SignUpRequest;
import org.jspecify.annotations.Nullable;


public interface AuthService {
      AuthResponseDto signup(SignUpRequest signUpRequest);

     AuthResponseDto login(LoginRequestDto loginRequest);
}
