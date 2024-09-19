package com.example.carRentals_service.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carModel;
    private String rentalDate;
    private String returnDate;
    private Long userId;

    public CarRental() {
    }

    public CarRental(String carModel, String rentalDate, String returnDate, Long userId) {
        this.carModel = carModel;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public String getReturnDate() {
        return this.returnDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
