package com.backend.realtimeapp_backend.dtos;

import com.backend.realtimeapp_backend.entities.Role;
import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String message;
    private String name;
    private Role role;
}
