package co.gov.banrep.kepiaa.commons.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
@ToString
public class ExceptionResponseDTO {

    protected LocalDateTime timestamp;
    protected String path;
    protected String cause;
    protected String details;
    protected Map<String,String> validations;
    protected String stackTrace;
}
