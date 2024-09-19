package com.example.booking_service.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;  // Refers to the associated booking
    private Date paymentDate;
    private Double amount;
    private String paymentStatus;  // E.g., "Processed", "Failed", "Pending"

    public Payment() {
        this.paymentStatus = "Pending";  // Default status when payment is initiated
    }

    public Payment(Long bookingId, Double amount) {
        this.bookingId = bookingId;
        this.amount = amount;
        this.paymentDate = new Date();
        this.paymentStatus = "Processed";  // Payment processed upon creation
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Mark the payment as processed
    public void processPayment() {
        this.paymentStatus = "Processed";
    }

    // Mark the payment as failed
    public void failPayment() {
        this.paymentStatus = "Failed";
    }
}
