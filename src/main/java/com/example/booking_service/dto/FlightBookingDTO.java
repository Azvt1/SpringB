package com.example.booking_service.dto;

import com.example.flightbooking_service.domain.entity.FlightBooking;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;


import java.time.LocalDateTime;

public class FlightBookingDTO extends BookingDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String flightNumber;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

    // Constructors
    public FlightBookingDTO() {}

    public FlightBookingDTO(Long userId, String flightNumber, LocalDateTime bookingDate, String status, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        super(userId, bookingDate, status, "FLIGHT");
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public void setStatus(String status) {
        super.setStatus(status);
    }

    // Getters and Setters
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}

