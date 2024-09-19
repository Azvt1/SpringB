package com.example.booking_service.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long paymentId;  // Refers to the associated payment
    private Date refundDate;
    private Double refundAmount;
    private String refundStatus;  // E.g., "Processed", "Failed", "Pending"

    public Refund() {
        this.refundStatus = "Pending";  // Default status when refund is initiated
    }

    public Refund(Long paymentId, Double refundAmount) {
        this.paymentId = paymentId;
        this.refundAmount = refundAmount;
        this.refundDate = new Date();
        this.refundStatus = "Processed";  // Refund processed upon creation
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    // Process the refund
    public void processRefund() {
        this.refundStatus = "Processed";
    }

    // Fail the refund
    public void failRefund() {
        this.refundStatus = "Failed";
    }
}
