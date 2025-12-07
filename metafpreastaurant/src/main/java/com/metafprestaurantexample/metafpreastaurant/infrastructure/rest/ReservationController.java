package com.metafprestaurantexample.metafpreastaurant.infrastructure.rest;

import com.metafprestaurantexample.metafpreastaurant.application.ReservationService;
import com.metafprestaurantexample.metafpreastaurant.domain.ReservationRequest;
import com.metafprestaurantexample.metafpreastaurant.dto.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationDto create(@RequestBody ReservationRequest request) {
        return reservationService.createReservation(request);
    }

    @PutMapping("/close/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public String closeUserReservations(@PathVariable UUID userId) {
        reservationService.closeReservations(userId);
        return "Reservations closed for user " + userId;
    }
}

