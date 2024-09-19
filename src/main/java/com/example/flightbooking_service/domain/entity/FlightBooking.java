package com.example.flightbooking_service.domain.entity;

import com.example.booking_service.entity.Booking;
import jakarta.persistence.*;

@Entity
public class FlightBooking extends Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private String departureDate;
    private String arrivalDate;

    // Store the userId instead of the full User entity
    private Long userId;

    // Default constructor
    public FlightBooking() {
        super();
    }


    // Parameterized constructor
    public FlightBooking(String flightNumber, String departureDate, String arrivalDate, Long userId) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.userId = userId;
    }


    public FlightBooking(Long userId, String flightNumber, String departureDate, String arrivalDate, String status) {
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

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
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
}
