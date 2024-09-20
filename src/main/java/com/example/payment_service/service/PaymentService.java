package com.example.payment_service.service;

import com.example.booking_service.dto.PaymentDTO;
import com.example.booking_service.entity.Booking;
import com.example.payment_service.entity.Payment;
import com.example.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingServiceClient bookingServiceClient;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, BookingServiceClient bookingServiceClient) {
        this.paymentRepository = paymentRepository;
        this.bookingServiceClient = bookingServiceClient;
    }

    public Payment makePayment(PaymentDTO paymentDTO) {
        // Check if booking exists via the BookingServiceClient
        Booking booking = bookingServiceClient.getBookingById(paymentDTO.getBookingId());

        if (booking == null) {
            throw new RuntimeException("Booking not found");
        }

        // Create payment record
        Payment payment = new Payment();
        payment.setBookingId(paymentDTO.getBookingId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
        payment.setPaymentDate(LocalDateTime.now());
        payment.setPaymentStatus("PAID");

        paymentRepository.save(payment);

        // Update the booking status
        bookingServiceClient.updateBookingStatus(paymentDTO.getBookingId(), "PAID");

        return payment;
    }

    public void cancelPayment(Long bookingId) {

        // Update the booking status
        bookingServiceClient.updateBookingStatus(bookingId, "CANCELED");
    }
}

