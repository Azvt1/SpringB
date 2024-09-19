package com.example.usermanagement_service.dto;

import com.example.booking_service.dto.BookingDTO;
import com.example.usermanagement_service.domain.valueobject.Email;

import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private Email email;
    private List<BookingDTO> bookings;

    public UserDTO() {

    }

    public UserDTO(Long id, String name, Email email, List<BookingDTO> bookings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bookings = bookings;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookings(List<BookingDTO> bookings) {
        this.bookings = bookings;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<BookingDTO> getBookings() {
        return bookings;
    }

    public Email getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    // Constructors, Getters, and Setters
}

