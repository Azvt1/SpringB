package com.example.usermanagement_service.domain.service;

import com.example.usermanagement_service.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserDomainService {
    public void validateUser(User user) {
        // Domain logic to validate a new user
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
    }
}
