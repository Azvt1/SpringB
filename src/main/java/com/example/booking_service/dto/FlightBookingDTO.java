package com.example.booking_service.dto;

import com.example.flightbooking_service.domain.entity.FlightBooking;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class FlightBookingDTO {

    private Long userId;
    private String flightNumber;
    private LocalDateTime bookingDate;
    private String status;

    private LocalDateTime departureDate;

    private LocalDateTime arrivalDate;

    private String bookingType;

    // Constructors
    public FlightBookingDTO() {}

    public FlightBookingDTO(Long userId, String flightNumber, LocalDateTime bookingDate, String status) {
        this.userId = userId;
        this.flightNumber = flightNumber;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public FlightBookingDTO(Long userId,  String flightNumber, LocalDateTime bookingDate, String status, String bookingType, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.userId = userId;
        this.flightNumber = flightNumber;
        this.bookingDate = bookingDate;
        this.status = status;
        this.bookingType = bookingType;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }


    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
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
