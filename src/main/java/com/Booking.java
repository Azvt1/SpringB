package com.example.booking_service.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Date bookingDate;
    private String status; // e.g., "Pending", "Paid", "Canceled"
    private Double totalAmount;

    public Booking() {
        this.status = "Pending"; // Default status when booking is created
    }

    public Booking(Long userId, Date bookingDate, Double totalAmount) {
        this.userId = userId;
        this.bookingDate = bookingDate;
        this.totalAmount = totalAmount;
        this.status = "Pending";
    }

    // Getters and setters

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

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // Methods to update status
    public void markAsPaid() {
        this.status = "Paid";
    }

    public void cancel() {
        this.status = "Canceled";
    }
}
