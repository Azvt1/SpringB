package com.example.flightbooking_service.controller;

import com.example.flightbooking_service.domain.entity.FlightBooking;
import com.example.flightbooking_service.service.FlightBookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/flightbookings")
public class FlightBookingController {

    private final FlightBookingService flightBookingService;

    public FlightBookingController(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    @PostMapping
    public FlightBooking createFlightBooking(@RequestBody FlightBooking flightBooking) {
        return flightBookingService.createFlightBooking(flightBooking.getFlightNumber(), flightBooking.getDepartureDate(), flightBooking.getArrivalDate(), flightBooking.getUserId());
    }

    @GetMapping
    public List<FlightBooking> getAllFlightBookings() {
        return flightBookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public FlightBooking getFlightBooking(@PathVariable Long id) {
        return flightBookingService.getFlightBooking(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFlightBooking(@PathVariable Long id) {
        flightBookingService.deleteFlightBooking(id);
    }
}
