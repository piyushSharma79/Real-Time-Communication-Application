package com.backend.realtimeapp_backend.services;

import com.backend.realtimeapp_backend.dtos.*;
import com.backend.realtimeapp_backend.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
    UserProfileResponse getMyProfile();
}
