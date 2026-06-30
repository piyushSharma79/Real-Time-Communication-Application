package com.backend.realtimeapp_backend.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
    private String path;
    private Map<String, String> errors;
}
