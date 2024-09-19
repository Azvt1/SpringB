package com.example.booking_service.service;

import com.example.booking_service.dto.FlightBookingDTO;
import com.example.booking_service.entity.Booking;
import com.example.booking_service.dto.BookingDTO;
import com.example.booking_service.repository.BookingRepository;
import com.example.flightbooking_service.domain.entity.FlightBooking;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    private final RestTemplate restTemplate;

    public BookingService(BookingRepository bookingRepository, RestTemplate restTemplate) {
        this.bookingRepository = bookingRepository;
        this.restTemplate = restTemplate;
    }

    // Create a new booking
    public Booking createBooking(BookingDTO bookingDTO) {
        if (bookingDTO.getBookingType().equals("FLIGHT")) {
            FlightBookingDTO flightBookingDTO = restTemplate.postForObject(
                    "http://localhost:8082/api/flightbookings",
                    bookingDTO,
                    FlightBookingDTO.class
            );
            System.out.println(flightBookingDTO.getFlightNumber());
            // Create a simple booking representation for your service (if needed)
            Booking flightBooking = new Booking();
            flightBooking.setUserId(bookingDTO.getUserId());
            flightBooking.setBookingType("FLIGHT");
//            flightBooking.setStatus(bookingDTO.getStatus());
            flightBooking.setBookingDate(bookingDTO.getBookingDate());

            // Save this as a simple record in your booking service (not FlightBooking entity)
            return bookingRepository.save(flightBooking);

        } else if (bookingDTO.getBookingType().equals("CAR_RENTALS")) {
            // MUST BE CHANGED TO CAR RENTALS
            FlightBookingDTO flightBookingDTO = restTemplate.postForObject(
                    "http://localhost:8082/api/flightbookings",
                    bookingDTO,
                    FlightBookingDTO.class
            );
            // Create a simple booking representation for your service (if needed)
            Booking flightBooking = new Booking();
            flightBooking.setUserId(bookingDTO.getUserId());
            flightBooking.setBookingType("FLIGHT");
//            flightBooking.setStatus(bookingDTO.getStatus());
            flightBooking.setBookingDate(flightBookingDTO.getBookingDate());

            // Save this as a simple record in your booking service (not FlightBooking entity)
            return bookingRepository.save(flightBooking);
        } else {
            // MUST BE CHANGED TO HOTEL
            FlightBookingDTO flightBookingDTO = restTemplate.postForObject(
                    "http://localhost:8082/api/flightbookings",
                    bookingDTO,
                    FlightBookingDTO.class
            );
            Booking flightBooking = new Booking();
            flightBooking.setUserId(bookingDTO.getUserId());
            flightBooking.setBookingType("FLIGHT");
//            flightBooking.setStatus(bookingDTO.getStatus());
            flightBooking.setBookingDate(flightBookingDTO.getBookingDate());

            // Save this as a simple record in your booking service (not FlightBooking entity)
            return bookingRepository.save(flightBooking);
        }
    }

    public Booking findBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteBookingById(id);
    }

    // Get all bookings for a specific user
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public void updateBookingStatus(Long bookingId, String status) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
        if(bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setStatus(status);
            bookingRepository.save(booking);
        } else {
            throw new IllegalArgumentException("Booking with id " + bookingId + "was not found");
        }
    }
}



