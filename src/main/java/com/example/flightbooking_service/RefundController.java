package com.example.booking_service.controller;

import com.example.booking_service.domain.entity.Refund;
import com.example.booking_service.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/refunds")
public class RefundController {

    @Autowired
    private RefundService refundService;

    // Create a refund for a payment
    @PostMapping
    public ResponseEntity<Refund> createRefund(@RequestParam Long paymentId, @RequestParam Double amount) {
        Refund refund = refundService.createRefund(paymentId, amount);
        return ResponseEntity.ok(refund);
    }

    // Process a refund
    @PostMapping("/{id}/process")
    public ResponseEntity<Refund> processRefund(@PathVariable Long id) {
        Refund refund = refundService.processRefund(id);
        return ResponseEntity.ok(refund);
    }
}
