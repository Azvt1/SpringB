package com.travelbooking.infrastructure;

import com.travelbooking.domain.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Custom query methods can be added here if necessary
}
