package Project.ai_workspace_platform.Entity;

import java.time.Instant;

public class UsageLog {

    Long id;
    User user;
    Project project;
    String action;
    Integer tokenUsed;
    Integer durationMs;
    Instant createdAt;

    String metaData; // store neccesary info

}
