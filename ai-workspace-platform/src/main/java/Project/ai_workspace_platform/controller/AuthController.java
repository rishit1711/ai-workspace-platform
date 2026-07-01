package Project.ai_workspace_platform.controller;

import Project.ai_workspace_platform.dto.Auth.AuthResponseDto;
import Project.ai_workspace_platform.dto.Auth.LoginRequestDto;
import Project.ai_workspace_platform.dto.Auth.SignUpRequest;
import Project.ai_workspace_platform.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authService.signup(signUpRequest));

    }
    public ResponseEntity<AuthResponseDto>  login(@RequestBody LoginRequestDto loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));

    }
}
