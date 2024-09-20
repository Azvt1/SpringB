package com.example.booking_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

import java.awt.print.Book;
import java.time.LocalDateTime;

public class BookingDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("userId")
    private Long userId;
    private String bookingType;
    private String status;
    private LocalDateTime bookingDate;

    private String flightNumber;

    private LocalDateTime departureDate;

    private LocalDateTime arrivalDate;

    public BookingDTO() {
    }


    // Constructors, Getters, and Setters
    public BookingDTO(Long userId, String bookingType, String status, LocalDateTime bookingDate) {
        this.userId = userId;
        this.bookingType = bookingType;
        this.status = status;
        this.bookingDate = bookingDate;
    }

    public BookingDTO(Long userId, LocalDateTime bookingDate, String status, String bookingType) {
        this.userId = userId;
        this.bookingDate = bookingDate;
        this.status = status;
        this.bookingType = bookingType;
    }

    public BookingDTO(Long userId) {
        this.userId = userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    // for flight

    public BookingDTO(Long userId, LocalDateTime bookingDate, String status, String bookingType, String flightNumber, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.userId= userId;
        this.bookingType = bookingType;
        // this.status = status;
        this.flightNumber = flightNumber;
        this.bookingDate = bookingDate;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }



    public void setUserId(Long userId) {
        this.userId = userId;
    }

//    public void setStatus(String status) {
//        this.status = status;
//    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public Long getUserId() {
        return userId;
    }



//    public String getStatus() {
//        return status;
//    }

//    public Long getId() {
//        return id;
//    }

    public String getBookingType() {
        return bookingType;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
}

