package com.example.booking_service.controller;

import com.example.booking_service.domain.entity.Payment;
import com.example.booking_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Create a payment for a booking
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestParam Long bookingId, @RequestParam Double amount) {
        Payment payment = paymentService.createPayment(bookingId, amount);
        return ResponseEntity.ok(payment);
    }

    // Mark a payment as processed
    @PostMapping("/{id}/process")
    public ResponseEntity<Payment> processPayment(@PathVariable Long id) {
        Payment payment = paymentService.processPayment(id);
        return ResponseEntity.ok(payment);
    }
}
