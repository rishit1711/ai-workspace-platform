package Project.ai_workspace_platform.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatSession {

    Project project;
    User user;
    String  title;
    Instant updatedAt;
    Instant createdAt;
    Instant deletedAt;
}
