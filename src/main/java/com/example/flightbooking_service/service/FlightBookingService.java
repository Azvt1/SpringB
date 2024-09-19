package com.example.flightbooking_service.service;

import com.example.flightbooking_service.domain.entity.FlightBooking;
import com.example.flightbooking_service.domain.service.FlightBookingDomainService;
import com.example.flightbooking_service.infrastructure.persistence.FlightBookingPersistenceAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class FlightBookingService {

    private final FlightBookingPersistenceAdapter flightBookingPersistenceAdapter;
    private final FlightBookingDomainService flightBookingDomainService;

    private final RestTemplate restTemplate;

    public FlightBookingService(FlightBookingPersistenceAdapter flightBookingPersistenceAdapter,
                                FlightBookingDomainService flightBookingDomainService, RestTemplate restTemplate) {
        this.flightBookingPersistenceAdapter = flightBookingPersistenceAdapter;
        this.flightBookingDomainService = flightBookingDomainService;
        this.restTemplate = restTemplate;
    }

    public FlightBooking createFlightBooking(String flightNumber, String departureDate, String arrivalDate, Long userId) {
        FlightBooking flightBooking = new FlightBooking(flightNumber, departureDate, arrivalDate, userId);
        return flightBookingPersistenceAdapter.save(flightBooking);
    }

    public List<FlightBooking> getBookingsByUserId(Long userId) {
        return flightBookingPersistenceAdapter.findById(userId);
    }

    public List<FlightBooking> getAllBookings() {
        return flightBookingPersistenceAdapter.findAll();
    }


    public FlightBooking getFlightBooking(Long id) {
        return flightBookingPersistenceAdapter.findSingleBookingById(id);
    }

    public void deleteFlightBooking(Long id) {
        flightBookingPersistenceAdapter.delete(id);
    }
}
