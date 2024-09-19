package com.example.flightbooking_service.infrastructure.persistence;

import com.example.flightbooking_service.domain.entity.FlightBooking;
import com.example.flightbooking_service.infrastructure.repository.FlightBookingRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class FlightBookingPersistenceAdapter {

    private final FlightBookingRepository flightBookingRepository;

    public FlightBookingPersistenceAdapter(FlightBookingRepository flightBookingRepository) {
        this.flightBookingRepository = flightBookingRepository;
    }

    public FlightBooking save(FlightBooking flightBooking) {
        return flightBookingRepository.save(flightBooking);
    }

    public List<FlightBooking> findAll() {
        return flightBookingRepository.findAll();
    }

    public List<FlightBooking> findById(Long id) {
        return flightBookingRepository.findByUserId(id);
    }

    public FlightBooking findSingleBookingById(Long id) {
        return flightBookingRepository.findFlightBookingById(id);
    }

    public void delete(Long id) {
        flightBookingRepository.deleteById(id);
    }
}
