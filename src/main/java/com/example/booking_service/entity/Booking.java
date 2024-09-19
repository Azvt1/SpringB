package com.example.booking_service.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public abstract class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private LocalDateTime bookingDate;
    private String status;

    private String bookingType; // FLIGHT, CAR_RENTAL, HOTEL

    // Constructors
    public Booking() {
        this.bookingDate = LocalDateTime.now();
        this.status = "PENDING";
    }

    public Booking(Long userId, String status) {
        this.userId = userId;
        this.bookingDate = LocalDateTime.now();
        this.status = status;
    }


    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Abstract method for subclasses to implement
    public abstract String getBookingType();
}
