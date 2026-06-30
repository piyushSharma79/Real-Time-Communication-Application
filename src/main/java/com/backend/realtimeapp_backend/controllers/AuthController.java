package com.backend.realtimeapp_backend.controllers;

import com.backend.realtimeapp_backend.dtos.RegisterRequest;
import com.backend.realtimeapp_backend.dtos.RegisterResponse;
import com.backend.realtimeapp_backend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public RegisterResponse register(@Valid @RequestBody RegisterRequest request){
        return userService.register(request);
    }
}
