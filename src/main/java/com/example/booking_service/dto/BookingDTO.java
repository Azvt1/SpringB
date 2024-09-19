package com.example.booking_service.dto;

public class BookingDTO {
    private Long id;
    private Long userId;
    private String bookingType;
    private String status;

    // Constructors, Getters, and Setters
    public BookingDTO(Long id, Long userId, String bookingType, String status) {
        this.id = id;
        this.userId = userId;
        this.bookingType = bookingType;
        this.status = status;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public String getBookingType() {
        return bookingType;
    }
}

