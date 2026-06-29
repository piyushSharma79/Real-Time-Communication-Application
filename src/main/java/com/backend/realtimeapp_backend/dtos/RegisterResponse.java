package com.backend.realtimeapp_backend.dtos;

import lombok.Data;

@Data
public class RegisterResponse {
    private String message;
    private Long userId;
    private String name;
}
