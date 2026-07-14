package Project.ai_workspace_platform.advices;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.Instant;
@Builder
public record ApiError(

        Instant timestamp,
        int status,
        String error,
        String message,
        String path

) {
    public ApiError(HttpStatus status, String message, String path) {
        this(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                path
        );
    }
}