package com.example.booking_service.dto;

import java.time.LocalDateTime;

public class FlightBookingDTO {

    private Long userId;
    private String flightNumber;
    private LocalDateTime bookingDate;
    private String status;

    // Constructors
    public FlightBookingDTO() {}

    public FlightBookingDTO(Long userId, String flightNumber, LocalDateTime bookingDate, String status) {
        this.userId = userId;
        this.flightNumber = flightNumber;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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
}
