package com.example.booking_service.service;

import com.example.booking_service.domain.entity.Booking;
import com.example.booking_service.infrastructure.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // Create a new booking
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Get all bookings by user ID
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    // Get a booking by ID
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    // Mark a booking as paid
    public Booking markBookingAsPaid(Long id) {
        Booking booking = getBookingById(id);
        if (booking != null) {
            booking.markAsPaid();
            return bookingRepository.save(booking);
        }
        return null;
    }

    // Cancel a booking
    public Booking cancelBooking(Long id) {
        Booking booking = getBookingById(id);
        if (booking != null) {
            booking.cancel();
            return bookingRepository.save(booking);
        }
        return null;
    }
}
