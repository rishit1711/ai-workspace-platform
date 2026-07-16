package Project.ai_workspace_platform.service.impl;

import Project.ai_workspace_platform.Repository.UserRepository;
import Project.ai_workspace_platform.dto.Auth.UserProfileResponse;
import Project.ai_workspace_platform.entity.User;
import Project.ai_workspace_platform.exception.ResourceNotFoundException;
import Project.ai_workspace_platform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with email not found"));
    }

    @Override
    public UserProfileResponse getProfile(Long id) {
        return null;
    }
}