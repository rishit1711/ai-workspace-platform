package Project.ai_workspace_platform.mapper;

import Project.ai_workspace_platform.dto.Auth.AuthResponse;
import Project.ai_workspace_platform.dto.Auth.SignUpRequest;
import Project.ai_workspace_platform.dto.Auth.UserProfileResponse;
import Project.ai_workspace_platform.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignUpRequest request);
    AuthResponse toAuthResponse(User user);
    UserProfileResponse toprofileResponse(User user);
}
