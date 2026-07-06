package com.backend.realtimeapp_backend.controllers;

import com.backend.realtimeapp_backend.dtos.UserProfileResponse;
import com.backend.realtimeapp_backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> myProfile(){
        UserProfileResponse response = userService.getMyProfile();
        return ResponseEntity.ok(response);
    }
}
