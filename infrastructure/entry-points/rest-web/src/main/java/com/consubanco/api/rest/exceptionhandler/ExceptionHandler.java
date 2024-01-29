package com.consubanco.api.rest.exceptionhandler;

import com.consubanco.api.rest.dto.ErrorResponseDto;
import com.consubanco.exception.BadRequestException;
import com.consubanco.exception.DatabaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public
    ResponseEntity<ErrorResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        LOGGER.error(String.format("Exception %s caught, message: %s", ex.getClass().getName(), ex.getLocalizedMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponseDto.builder()
                        .errors(errors)
                        .message("Invalid Request contract")
                        .build());
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    public
    ResponseEntity<ErrorResponseDto> handleBadRequestExceptions(BadRequestException ex) {

        LOGGER.error(String.format("Exception %s caught, message: %s", ex.getClass().getName(), ex.getLocalizedMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponseDto.builder()
                        .errors(ex.getMessage())
                        .message("Invalid Request contract")
                        .build());
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(DatabaseException.class)
    public
    ResponseEntity<ErrorResponseDto> handleDatabaseExceptions(DatabaseException ex) {

        LOGGER.error(String.format("Exception %s caught, message: %s", ex.getClass().getName(), ex.getLocalizedMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponseDto.builder()
                        .errors(ex.getMessage())
                        .message("Invalid Request contract")
                        .build());
    }
}
