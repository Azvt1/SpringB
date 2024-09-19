package com.example.carRentals_service.infrastructure.repository;

import com.example.carRentals_service.domain.entity.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental, Long> {
    List<CarRental> findByUserId(Long userId);
}
