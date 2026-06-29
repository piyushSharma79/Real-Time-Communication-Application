package com.backend.realtimeapp_backend.services;

import com.backend.realtimeapp_backend.dtos.RegisterRequest;
import com.backend.realtimeapp_backend.dtos.RegisterResponse;
import com.backend.realtimeapp_backend.entities.Role;
import com.backend.realtimeapp_backend.entities.User;
import com.backend.realtimeapp_backend.exceptions.UserAlreadyExistsException;
import com.backend.realtimeapp_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = new User();
        if(userRepository.existsByEmail(request.getEmail())){
            throw new UserAlreadyExistsException("user already exists");

        }
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = this.userRepository.save(user);
        RegisterResponse response = new RegisterResponse();
        response.setUserId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setMessage("Registration successful");
        return response;
    }
}
