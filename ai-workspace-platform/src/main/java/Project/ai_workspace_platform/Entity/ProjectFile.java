package Project.ai_workspace_platform.Entity;

import java.time.Instant;

public class ProjectFile {
    private Long id;
    private Project project;
    private String path;
    private String minioObjectKey;
    private Instant createdAt;
    private Instant updatedAt;
    private User createdBy;
    private User updatedBy;
}
