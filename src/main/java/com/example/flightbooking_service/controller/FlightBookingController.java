package com.example.flightbooking_service.controller;

import com.example.booking_service.dto.FlightBookingDTO;
import com.example.flightbooking_service.domain.entity.FlightBooking;
import com.example.flightbooking_service.service.FlightBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/flightbookings")
public class FlightBookingController {

    private final FlightBookingService flightBookingService;

    public FlightBookingController(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    @PostMapping
    public ResponseEntity<FlightBookingDTO> createFlightBooking(@RequestBody FlightBookingDTO flightBookingDTO) {
        FlightBookingDTO savedBooking = flightBookingService.createFlightBooking(flightBookingDTO);
        System.out.println("FlightBooking Controller: " + flightBookingDTO.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
    }

    @GetMapping
    public List<FlightBooking> getAllFlightBookings() {
        return flightBookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public FlightBookingDTO getFlightBooking(@PathVariable Long id) {
        return flightBookingService.getFlightBooking(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFlightBooking(@PathVariable Long id) {
        flightBookingService.deleteFlightBooking(id);
    }
}
