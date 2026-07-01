package com.backend.realtimeapp_backend.services;

import com.backend.realtimeapp_backend.entities.User;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

    @Override
    public String generateToken(User user) {
        return "";
    }

    @Override
    public Boolean validateToken(String token, User user) {
        return null;
    }

    @Override
    public String extractEmail(String token) {
        return "";
    }

    @Override
    public Boolean isTokenExpired(String token) {
        return null;
    }
}
