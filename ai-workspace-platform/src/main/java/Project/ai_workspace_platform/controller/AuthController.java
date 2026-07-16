package Project.ai_workspace_platform.controller;

import Project.ai_workspace_platform.dto.Auth.AuthResponse;
import Project.ai_workspace_platform.dto.Auth.LoginRequestDto;
import Project.ai_workspace_platform.dto.Auth.SignUpRequest;
import Project.ai_workspace_platform.dto.Auth.UserProfileResponse;
import Project.ai_workspace_platform.service.AuthService;
import Project.ai_workspace_platform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignUpRequest signUpRequest){
        System.out.println("Signup API Hit");
        return ResponseEntity.ok(authService.signup(signUpRequest));

    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse>  login(@RequestBody LoginRequestDto loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));

    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> profile(@PathVariable Long id){
        return ResponseEntity.ok(userService.getProfile(id));
    }
}
