package com.example.booking_service.dto;

public class PaymentDTO {
    private Long bookingId;
    private double amount;
    private String paymentMethod;


    public Long getBookingId() {
        return bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
