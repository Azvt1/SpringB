package com.example.carRentals_service.controller;

import com.example.carRentals_service.domain.entity.CarRental;
import com.example.carRentals_service.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carRentals")
public class CarRentalController {

    @Autowired
    private CarRentalService carRentalService;

    @PostMapping
    public ResponseEntity<CarRental> createCarRental(@RequestBody CarRental carRental) {
        CarRental createdCarRental = carRentalService.createCarRental(carRental);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCarRental);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarRental> getCarRentalById(@PathVariable Long id) {
        CarRental carRental = carRentalService.getCarRentalById(id);
        return ResponseEntity.ok(carRental);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CarRental>> getCarRentalsByUserId(@PathVariable Long userId) {
        List<CarRental> carRentals = carRentalService.getCarRentalsByUserId(userId);
        return ResponseEntity.ok(carRentals);
    }
}
