package com.backend.realtimeapp_backend.services;

import com.backend.realtimeapp_backend.dtos.LoginRequest;
import com.backend.realtimeapp_backend.dtos.LoginResponse;
import com.backend.realtimeapp_backend.dtos.RegisterRequest;
import com.backend.realtimeapp_backend.dtos.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
}
