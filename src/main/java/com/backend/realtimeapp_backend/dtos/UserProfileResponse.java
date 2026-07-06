package com.backend.realtimeapp_backend.dtos;

import com.backend.realtimeapp_backend.entities.Role;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserProfileResponse {
    private String name;
    private Long id;
    private Role role;
    private String email;
    private LocalDateTime createdAt;
}
