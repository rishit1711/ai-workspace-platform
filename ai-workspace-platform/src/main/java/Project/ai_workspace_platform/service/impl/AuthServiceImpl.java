package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.dto.Auth.AuthResponseDto;
import Project.ai_workspace_platform.dto.Auth.LoginRequestDto;
import Project.ai_workspace_platform.dto.Auth.SignUpRequest;
import Project.ai_workspace_platform.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponseDto signup(SignUpRequest signUpRequest) {
        return null;
    }

    @Override
    public AuthResponseDto login(LoginRequestDto loginRequest) {
        return null;
    }
}
