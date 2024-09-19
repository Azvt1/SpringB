package com.example.booking_service.service;

import com.example.booking_service.entity.Booking;
import com.example.booking_service.dto.BookingDTO;
import com.example.booking_service.repository.BookingRepository;
import com.example.flightbooking_service.domain.entity.FlightBooking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Create a new booking
    public Booking createBooking(BookingDTO bookingDTO) {

        if (bookingDTO.getBookingType().equals("FLIGHT")) {
            Booking booking = new FlightBooking();
            booking.setUserId(bookingDTO.getUserId());
            booking.setBookingType(bookingDTO.getBookingType());
            booking.setStatus(bookingDTO.getStatus());
            return bookingRepository.save(booking);
        } else if (bookingDTO.getBookingType().equals("CAR_RENTALS")) {
            // MUST BE CHANGED TO CAR RENTALS
            Booking booking = new FlightBooking();
            booking.setUserId(bookingDTO.getUserId());
            booking.setBookingType(bookingDTO.getBookingType());
            booking.setStatus(bookingDTO.getStatus());
            return bookingRepository.save(booking);
        } else {
            // MUST BE CHANGED TO HOTEL
            Booking booking = new FlightBooking();
            booking.setUserId(bookingDTO.getUserId());
            booking.setBookingType(bookingDTO.getBookingType());
            booking.setStatus(bookingDTO.getStatus());
            return bookingRepository.save(booking);
        }
    }

    // Get all bookings for a specific user
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}

