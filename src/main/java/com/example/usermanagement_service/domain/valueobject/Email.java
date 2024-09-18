package com.example.usermanagement_service.domain.valueobject;

import jakarta.persistence.Embeddable;

@Embeddable
public class Email {

    private String emailAddress;

    // Constructors
    public Email() {}

    public Email(String emailAddress) {
        if (!emailAddress.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.emailAddress = emailAddress;
    }

    // Getters and Setters
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    // toString() method
    @Override
    public String toString() {
        return "Email{" +
                "emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
