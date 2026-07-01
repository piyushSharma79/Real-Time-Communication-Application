package com.backend.realtimeapp_backend.services;

import com.backend.realtimeapp_backend.entities.User;

public interface JwtService {
    String generateToken(User user);
    Boolean validateToken(String token, User user);
    String extractEmail(String token);
    Boolean isTokenExpired(String token);
}
