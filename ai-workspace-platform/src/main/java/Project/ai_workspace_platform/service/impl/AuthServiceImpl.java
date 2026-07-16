package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.Repository.UserRepository;
import Project.ai_workspace_platform.dto.Auth.AuthResponse;
import Project.ai_workspace_platform.dto.Auth.LoginRequestDto;
import Project.ai_workspace_platform.dto.Auth.SignUpRequest;
import Project.ai_workspace_platform.entity.User;
import Project.ai_workspace_platform.mapper.UserMapper;
import Project.ai_workspace_platform.security.JwtService;
import Project.ai_workspace_platform.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse signup(SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.email())){
            throw  new BadCredentialsException("User Already Exists");
        }

        User user = userMapper.toEntity(signUpRequest);
        user.setPassword(passwordEncoder.encode(signUpRequest.password()));
        userRepository.save(user);
        String token = jwtService.generateAccessToken(user);

        return new AuthResponse(token,userMapper.toprofileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequestDto loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(),loginRequest.password()));
        User user = (User) authentication.getPrincipal();
        String token = jwtService.generateAccessToken(user);

         return new AuthResponse(token,userMapper.toprofileResponse(user));
    }
}
