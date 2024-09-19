package com.example.flightbooking_service.infrastructure.repository;

import com.example.flightbooking_service.domain.entity.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {
    List<FlightBooking> findByUserId(Long userId);

    FlightBooking findFlightBookingById(Long flightId);
}

