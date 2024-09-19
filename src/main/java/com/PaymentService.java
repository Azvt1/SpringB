package com.example.booking_service.service;

import com.example.booking_service.domain.entity.Payment;
import com.example.booking_service.infrastructure.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Create a payment for a booking
    public Payment createPayment(Long bookingId, Double amount) {
        Payment payment = new Payment(bookingId, amount);
        return paymentRepository.save(payment);
    }

    // Get payment details by ID
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    // Mark payment as processed
    public Payment processPayment(Long id) {
        Payment payment = getPaymentById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.processPayment();
        return paymentRepository.save(payment);
    }
}
