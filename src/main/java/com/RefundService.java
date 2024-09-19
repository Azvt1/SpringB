package com.example.booking_service.service;

import com.example.booking_service.domain.entity.Refund;
import com.example.booking_service.infrastructure.repository.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RefundService {

    @Autowired
    private RefundRepository refundRepository;

    // Create a refund for a payment
    public Refund createRefund(Long paymentId, Double refundAmount) {
        Refund refund = new Refund(paymentId, refundAmount);
        return refundRepository.save(refund);
    }

    // Get refund details by ID
    public Optional<Refund> getRefundById(Long id) {
        return refundRepository.findById(id);
    }

    // Process a refund
    public Refund processRefund(Long id) {
        Refund refund = getRefundById(id).orElseThrow(() -> new RuntimeException("Refund not found"));
        refund.processRefund();
        return refundRepository.save(refund);
    }
}
