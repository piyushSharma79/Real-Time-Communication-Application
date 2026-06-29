package com.backend.realtimeapp_backend.dtos;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String password;
    private String email;
}
