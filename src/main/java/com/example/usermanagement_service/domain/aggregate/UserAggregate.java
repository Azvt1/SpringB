package com.example.usermanagement_service.domain.aggregate;

import com.example.usermanagement_service.domain.entity.User;
import com.example.usermanagement_service.domain.event.UserCreatedEvent;
import com.example.usermanagement_service.domain.valueobject.Email;

public class UserAggregate {

    private User user;

    // Constructor: Pass in the root entity (User)
    public UserAggregate(User user) {
        this.user = user;
    }

    // Logic to create a user with validation rules
    public User createUser(String name, String email, String password, String phoneNumber) {
        // Validation logic (example)
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }

        // Create a new user instance
        this.user = new User(name, new Email(email), password, phoneNumber);

        // Return the newly created user
        return this.user;
    }

    // Example aggregate logic to update the user's phone number
    public void updatePhoneNumber(String newPhoneNumber) {
        if (newPhoneNumber == null || newPhoneNumber.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
        this.user.setPhoneNumber(newPhoneNumber);
    }

    // Example aggregate logic to trigger a domain event when the user is created
    public UserCreatedEvent createUserEvent() {
        return new UserCreatedEvent(this.user); // Return an event that can be published
    }

    // Accessor for the user (aggregate root)
    public User getUser() {
        return user;
    }
}
