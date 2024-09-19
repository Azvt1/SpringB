package com.example.flightbooking_service.domain.service;

import com.example.flightbooking_service.domain.entity.FlightBooking;
import org.springframework.stereotype.Service;

@Service
public class FlightBookingDomainService {

    public void validateFlightBooking(FlightBooking flightBooking) {
        // Domain logic to validate a new flight booking
        if (flightBooking.getFlightNumber() == null || flightBooking.getFlightNumber().isEmpty()) {
            throw new IllegalArgumentException("Flight number cannot be empty");
        }

    }
}
