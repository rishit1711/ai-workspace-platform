package Project.ai_workspace_platform.advices;

import Project.ai_workspace_platform.exception.BadRequestException;
import Project.ai_workspace_platform.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> badRequest(BadRequestException ex, HttpServletRequest request){
        ApiError error = ApiError.builder().
                status(HttpStatus.BAD_REQUEST.value())
                        .error("Bad Request")
                                .message(ex.getMessage())
                                        .path(request.getRequestURI())
                                                .timestamp(Instant.now()).build();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> badRequest(ResourceNotFoundException ex, HttpServletRequest request){
        ApiError error = ApiError.builder().
                status(HttpStatus.NOT_FOUND.value())
                .error("Bad Request")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleException(MethodArgumentNotValidException ex,HttpServletRequest request){
        ApiError error = ApiError.builder().
                status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .timestamp(Instant.now()).build();

        return ResponseEntity.badRequest().body(error);
    }


}
