package com.backend.realtimeapp_backend.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
