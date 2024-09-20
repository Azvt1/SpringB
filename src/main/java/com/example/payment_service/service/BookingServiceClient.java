package com.example.payment_service.service;

import com.example.booking_service.entity.Booking;
import com.example.flightbooking_service.domain.entity.FlightBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingServiceClient {

    private final RestTemplate restTemplate;

    @Autowired
    public BookingServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Booking getBookingById(Long bookingId) {
        // Call to the Booking service
        return restTemplate.getForObject("http://localhost:8081/api/bookings/" + bookingId, Booking.class);
    }

    public void updateBookingStatus(Long bookingId, String status) {
        restTemplate.put("http://localhost:8081/api/bookings/" + bookingId + "/status", status);
    }
}

