package com.example.flightbooking_service.domain.entity;

import com.example.booking_service.entity.Booking;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class FlightBooking extends Booking {

    private String flightNumber;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;


    // Default constructor
    public FlightBooking() {
        super();
    }


    // Parameterized constructor
    public FlightBooking(Long userId, String flightNumber, LocalDateTime departureDate, LocalDateTime arrivalDate, String status) {
        super(userId, status);
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
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

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Long getUserId() {
        return super.getUserId();
    }
    @Override
    public String getBookingType() {
        return "FLIGHT";
    }

    // Example of a domain method to check if the flight booking is valid
    public boolean isValidBooking() {
        return flightNumber != null && !flightNumber.isEmpty() &&
                departureDate != null && arrivalDate != null &&
                super.getUserId() != null;
    }

    @Override
    public String toString() {
        return "FlightBooking{" +
                "id=" + super.getId() +
                ", userId=" + getUserId() +
                ", flightNumber='" + flightNumber + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", userId=" + super.getUserId() +
                ", bookingType='" + getBookingType() + '\'' +
                ", bookingDate=" + getBookingDate() +
                ", status='" + getStatus() + '\'' +
                '}';
    }

}
