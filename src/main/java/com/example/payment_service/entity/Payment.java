package com.example.payment_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;
    private double amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;
    private String paymentStatus;

    // Constructor, Getters, and Setters...

    public Payment() {}

    public Payment(Long bookingId, double amount, LocalDateTime paymentDate, String paymentMethod, String paymentStatus) {
        this.bookingId = bookingId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

