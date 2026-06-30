package com.backend.realtimeapp_backend.exceptions;

import com.backend.realtimeapp_backend.dtos.ErrorResponse;
import com.backend.realtimeapp_backend.dtos.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(
            UserAlreadyExistsException exception,
            WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(HttpStatus.CONFLICT.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setPath(request.getDescription(false).replace("uri=",""));

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException exception,
            WebRequest request){
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage("Validation Failed");
        response.setTimestamp(LocalDateTime.now());
        response.setPath(request.getDescription(false).replace("uri=", ""));
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        response.setErrors(errors);

        return ResponseEntity
                .badRequest()
                .body(response);
    }

}

