package com.example.flightbooking_service.domain.entity;

import com.example.booking_service.entity.Booking;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class FlightBooking extends Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

    // Store the userId instead of the full User entity
    private Long userId;

    // Default constructor
    public FlightBooking() {
        super();
    }


    // Parameterized constructor
    public FlightBooking(String flightNumber, LocalDateTime departureDate, LocalDateTime arrivalDate, Long userId) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.userId = userId;
    }

    public FlightBooking(Long userId) {
        this.userId = userId;
    }


    public FlightBooking(Long userId, String flightNumber, LocalDateTime departureDate, LocalDateTime arrivalDate, String status) {
        super(userId, status);
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }
        // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getBookingType() {
        return "FLIGHT";
    }

    // Example of a domain method to check if the flight booking is valid
    public boolean isValidBooking() {
        return flightNumber != null && !flightNumber.isEmpty() &&
                departureDate != null && arrivalDate != null &&
                userId != null;
    }

    @Override
    public String toString() {
        return "FlightBooking{" +
                "id=" + id +
                ", userId=" + getUserId() +
                ", flightNumber='" + flightNumber + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", userId=" + userId +
                ", bookingType='" + getBookingType() + '\'' +
                ", bookingDate=" + getBookingDate() +
                ", status='" + getStatus() + '\'' +
                '}';
    }

}
