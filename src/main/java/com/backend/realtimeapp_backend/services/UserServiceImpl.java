package com.backend.realtimeapp_backend.services;

import com.backend.realtimeapp_backend.dtos.LoginRequest;
import com.backend.realtimeapp_backend.dtos.LoginResponse;
import com.backend.realtimeapp_backend.dtos.RegisterRequest;
import com.backend.realtimeapp_backend.dtos.RegisterResponse;
import com.backend.realtimeapp_backend.entities.Role;
import com.backend.realtimeapp_backend.entities.User;
import com.backend.realtimeapp_backend.exceptions.InvalidCredentialsException;
import com.backend.realtimeapp_backend.exceptions.UserAlreadyExistsException;
import com.backend.realtimeapp_backend.repositories.UserRepository;
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

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                    new InvalidCredentialsException("Invalid email or password")
                );
                if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
                    throw new InvalidCredentialsException("Invalid Email or Password");
                }
                LoginResponse response = new LoginResponse();
                response.setToken("");
                response.setName(user.getName());
                response.setMessage("Login successfully");
                response.setRole(user.getRole());
        return response;
    }
}
