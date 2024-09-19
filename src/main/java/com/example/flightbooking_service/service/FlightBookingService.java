package com.example.flightbooking_service.service;

import com.example.booking_service.dto.FlightBookingDTO;
import com.example.flightbooking_service.domain.entity.FlightBooking;
import com.example.flightbooking_service.domain.service.FlightBookingDomainService;
import com.example.flightbooking_service.infrastructure.persistence.FlightBookingPersistenceAdapter;
import com.example.flightbooking_service.infrastructure.repository.FlightBookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class FlightBookingService {

    private final FlightBookingPersistenceAdapter flightBookingPersistenceAdapter;
    private final FlightBookingDomainService flightBookingDomainService;

    private final FlightBookingRepository flightBookingRepository;

    private final RestTemplate restTemplate;

    public FlightBookingService(FlightBookingPersistenceAdapter flightBookingPersistenceAdapter,
                                FlightBookingDomainService flightBookingDomainService, RestTemplate restTemplate, FlightBookingRepository flightBookingRepository) {
        this.flightBookingPersistenceAdapter = flightBookingPersistenceAdapter;
        this.flightBookingDomainService = flightBookingDomainService;
        this.restTemplate = restTemplate;
        this.flightBookingRepository = flightBookingRepository;
    }

    public FlightBookingDTO createFlightBooking(FlightBookingDTO flightBookingDTO) {
        // Convert DTO to FlightBooking entity and save it
        System.out.println("this is id:" + flightBookingDTO.getUserId());
        FlightBooking flightBooking = new FlightBooking(flightBookingDTO.getUserId());
        flightBooking.setFlightNumber(flightBookingDTO.getFlightNumber());
        flightBooking.setBookingDate(flightBookingDTO.getBookingDate());
        flightBooking.setStatus(flightBookingDTO.getStatus());
        flightBooking.setDepartureDate(flightBookingDTO.getDepartureDate());
        flightBooking.setArrivalDate(flightBookingDTO.getArrivalDate());


        System.out.println(flightBooking);

        flightBooking = flightBookingRepository.save(flightBooking);
        return convertToDTO(flightBooking);  // Convert back to DTO
    }

    private FlightBookingDTO convertToDTO(FlightBooking flightBooking) {
        return new FlightBookingDTO(
                flightBooking.getUserId(),
                flightBooking.getFlightNumber(),
                flightBooking.getBookingDate(),
                flightBooking.getStatus(),
                flightBooking.getBookingType(),
                flightBooking.getDepartureDate(),
                flightBooking.getArrivalDate()
        );
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
