package com.example.booking_service.service;

import com.example.booking_service.dto.FlightBookingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightBookingClient {

    private final RestTemplate restTemplate;

    @Autowired
    public FlightBookingClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FlightBookingDTO getFlightBookingById(Long bookingId) {
        String flightServiceUrl = "http://localhost:8082/api/flightbookings/" + bookingId;
        return restTemplate.getForObject(flightServiceUrl, FlightBookingDTO.class);
    }
}

