package com.example.usermanagement_service.infrastructure.persistence;

import com.example.usermanagement_service.domain.entity.User;
import com.example.usermanagement_service.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserPersistenceAdapter {

    private final UserRepository userRepository;

    public UserPersistenceAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Save User
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Find All Users
    public List<User> findAll() {
        return userRepository.findAll();  // Delegate to JPA repository
    }

    // Find User by ID
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Delete User by ID
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);  // Delegate to JPA repository
    }
}
