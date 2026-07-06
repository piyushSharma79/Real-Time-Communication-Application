package com.backend.realtimeapp_backend.services;

import com.backend.realtimeapp_backend.entities.User;
import com.backend.realtimeapp_backend.exceptions.InvalidCredentialsException;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Data
@Service
public class CurrentUserServiceImpl implements CurrentUserService {
    @Override
    public User getCurrentUser() {
        Authentication authentication =
        SecurityContextHolder
                .getContext()
                .getAuthentication();
        if(authentication == null){
            throw new InvalidCredentialsException("No authenticated user found");
        }
        else{
        Object principal = authentication.getPrincipal();
        if(principal instanceof User user){
            return user;
        }
        throw new InvalidCredentialsException("Authentication principal is not valid user");
        }

    }
}
