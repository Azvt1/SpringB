package com.example.usermanagement_service.service;

import com.example.usermanagement_service.domain.entity.User;
import com.example.usermanagement_service.domain.event.UserCreatedEvent;
import com.example.usermanagement_service.domain.service.UserDomainService;
import com.example.usermanagement_service.infrastructure.persistence.UserPersistenceAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserPersistenceAdapter userPersistenceAdapter;
    private final UserDomainService userDomainService;

    public UserService(UserPersistenceAdapter userPersistenceAdapter, UserDomainService userDomainService) {
        this.userPersistenceAdapter = userPersistenceAdapter;
        this.userDomainService = userDomainService;
    }

    public User createUser(User user) {
        userDomainService.validateUser(user);  // Domain logic
        User savedUser = userPersistenceAdapter.saveUser(user);
        publishEvent(new UserCreatedEvent(savedUser));
        return savedUser;
    }

    public List<User> getAllUsers() {
        return userPersistenceAdapter.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userPersistenceAdapter.findUserById(id);
    }

    public void deleteUser(Long id) {
        userPersistenceAdapter.deleteUserById(id);
    }

    private void publishEvent(UserCreatedEvent event) {
        // Publish event (could use Spring EventPublisher)
    }
}
