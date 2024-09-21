package com.example.payment_service.controller;


import com.example.booking_service.dto.PaymentDTO;
import com.example.payment_service.entity.Payment;
import com.example.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public ResponseEntity<Payment> makePayment(@RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentService.makePayment(paymentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }

    @PostMapping("/cancel/{bookingId}")
    public ResponseEntity<Map<String, Object>> cancelPayment(@PathVariable Long bookingId) {
        // Perform the cancel payment logic
        paymentService.cancelPayment(bookingId);

        // Create a response map with the required fields
        Map<String, Object> response = new HashMap<>();
        response.put("id", bookingId);
        response.put("status", "Canceled");

        // Return the response entity with the map
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
