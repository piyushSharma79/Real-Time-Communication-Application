package com.backend.realtimeapp_backend.services;

import com.backend.realtimeapp_backend.entities.Role;
import com.backend.realtimeapp_backend.entities.User;

public interface JwtService {
    String generateToken(String email, Role role);
    boolean validateToken(String token, String email);
    String extractEmail(String token);
    boolean isTokenExpired(String token);
}
