package com.example.flightbooking_service.infrastructure.persistence;

import com.example.booking_service.dto.FlightBookingDTO;
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

    public FlightBookingDTO findSingleBookingById(Long id) {
        FlightBooking flightBooking = flightBookingRepository.findFlightBookingById(id);
        return mapToDTO(flightBooking);
    }

    private FlightBookingDTO mapToDTO(FlightBooking flightBooking) {
        FlightBookingDTO dto = new FlightBookingDTO(flightBooking.getUserId(), flightBooking.getFlightNumber(), flightBooking.getBookingDate(), flightBooking.getStatus(), flightBooking.getDepartureDate(), flightBooking.getArrivalDate());
        return dto;
    }


    public void delete(Long id) {
        flightBookingRepository.deleteById(id);
    }
}
