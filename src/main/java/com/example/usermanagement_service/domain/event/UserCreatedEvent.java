package com.example.usermanagement_service.domain.event;

import com.example.usermanagement_service.domain.entity.User;

public class UserCreatedEvent {
    private final User user;

    public UserCreatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
