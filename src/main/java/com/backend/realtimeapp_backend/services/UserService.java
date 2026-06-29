package com.backend.realtimeapp_backend.services;

import com.backend.realtimeapp_backend.dtos.RegisterRequest;
import com.backend.realtimeapp_backend.dtos.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
}
