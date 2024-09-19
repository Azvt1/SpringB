package com.example.usermanagement_service.service;

import com.example.booking_service.dto.BookingDTO;
import com.example.usermanagement_service.domain.entity.User;
import com.example.usermanagement_service.domain.event.UserCreatedEvent;
import com.example.usermanagement_service.domain.service.UserDomainService;
import com.example.usermanagement_service.dto.UserDTO;
import com.example.usermanagement_service.infrastructure.persistence.UserPersistenceAdapter;
import com.example.usermanagement_service.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserPersistenceAdapter userPersistenceAdapter;
    private final UserDomainService userDomainService;

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    public UserService(UserPersistenceAdapter userPersistenceAdapter, UserDomainService userDomainService, RestTemplate restTemplate, UserRepository userRepository) {
        this.userPersistenceAdapter = userPersistenceAdapter;
        this.userDomainService = userDomainService;
        this.restTemplate = restTemplate;
        this.userRepository = userRepository;
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

    public UserDTO getUserWithBookings(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        BookingDTO[] bookings = restTemplate.getForObject("http://localhost:8082/api/bookings/user" + userId, BookingDTO[].class);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setBookings(Arrays.asList(bookings));

        return userDTO;
    }
}
