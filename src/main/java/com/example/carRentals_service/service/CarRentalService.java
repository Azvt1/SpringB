package com.example.carRentals_service.service;

import com.example.carRentals_service.domain.entity.CarRental;
import com.example.carRentals_service.infrastructure.repository.CarRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRentalService {

    @Autowired
    private CarRentalRepository carRentalRepository;

    public CarRental createCarRental(CarRental carRental) {
        return carRentalRepository.save(carRental);
    }

    public CarRental getCarRentalById(Long id) {
        return carRentalRepository.findById(id).orElse(null);
    }

    public List<CarRental> getCarRentalsByUserId(Long userId) {
        return carRentalRepository.findByUserId(userId);
    }
}
