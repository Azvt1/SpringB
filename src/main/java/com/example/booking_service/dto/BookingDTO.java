package com.example.booking_service.dto;

import java.time.LocalDateTime;

public class BookingDTO {
   // private Long id;
    private Long userId;
    private String bookingType;
    private String status;

    private LocalDateTime bookingDate;

    // Constructors, Getters, and Setters
    public BookingDTO(Long id, Long userId, String bookingType, String status, LocalDateTime bookingDate) {
       // this.id = id;
        this.userId = userId;
        this.bookingType = bookingType;
        this.status = status;
        this.bookingDate = bookingDate;
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

//    public void setId(Long id) {
//        this.id = id;
//    }

    public Long getUserId() {
        return userId;
    }



    public String getStatus() {
        return status;
    }

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

