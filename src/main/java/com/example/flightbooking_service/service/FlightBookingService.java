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
        System.out.println("FlightBookingService: " + flightBookingDTO.getUserId());
        FlightBooking flightBooking = new FlightBooking(
                flightBookingDTO.getUserId(),
                flightBookingDTO.getFlightNumber(),
                flightBookingDTO.getDepartureDate(),
                flightBookingDTO.getArrivalDate(),
                "PENDING"
        );
        System.out.println("FlightBookingService after creating: " + flightBookingDTO.getUserId());
        flightBooking = flightBookingRepository.save(flightBooking);
        return convertToDTO(flightBooking);
    }

    private FlightBookingDTO convertToDTO(FlightBooking flightBooking) {
        System.out.println("Converting to dto" + flightBooking.getUserId());
        FlightBookingDTO flightBookingDTO = new FlightBookingDTO(
                flightBooking.getUserId(),
                flightBooking.getFlightNumber(),
                flightBooking.getBookingDate(),
                flightBooking.getStatus(),
                flightBooking.getDepartureDate(),
                flightBooking.getArrivalDate()
        );

        System.out.println("After creating in converting to dto: " + flightBookingDTO.getUserId());
        return flightBookingDTO;
    }


    public List<FlightBooking> getBookingsByUserId(Long userId) {
        return flightBookingPersistenceAdapter.findById(userId);
    }

    public List<FlightBooking> getAllBookings() {
        return flightBookingPersistenceAdapter.findAll();
    }


    public FlightBookingDTO getFlightBooking(Long id) {
        return flightBookingPersistenceAdapter.findSingleBookingById(id);
    }

    public void deleteFlightBooking(Long id) {
        flightBookingPersistenceAdapter.delete(id);
    }
}
