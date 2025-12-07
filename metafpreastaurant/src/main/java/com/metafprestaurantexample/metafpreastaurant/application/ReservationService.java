package com.metafprestaurantexample.metafpreastaurant.application;

import com.metafprestaurantexample.metafpreastaurant.domain.ReservationRequest;
import com.metafprestaurantexample.metafpreastaurant.dto.ReservationDto;
import com.metafprestaurantexample.metafpreastaurant.entity.Reservation;
import com.metafprestaurantexample.metafpreastaurant.entity.Restaurant;
import com.metafprestaurantexample.metafpreastaurant.entity.User;
import com.metafprestaurantexample.metafpreastaurant.infrastructure.repositories.ReservationRepository;
import com.metafprestaurantexample.metafpreastaurant.infrastructure.repositories.RestaurantRepository;
import com.metafprestaurantexample.metafpreastaurant.infrastructure.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public ReservationDto createReservation(ReservationRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        if (restaurant.getCurrentDiner() + request.getDiners() > restaurant.getCapacity()) {
            throw new RuntimeException("Not enough capacity in the restaurant");
        }

        restaurant.setCurrentDiner(restaurant.getCurrentDiner() + request.getDiners());
        restaurantRepository.save(restaurant);

        Reservation reservation = new Reservation(user, restaurant, request.getDiners());
        reservationRepository.save(reservation);

        return new ReservationDto(
                reservation.getId(),
                user.getUserId(),
                restaurant.getResId(),
                reservation.getDiners(),
                reservation.getActive()
        );
    }
    public void closeReservations(UUID userId) {

        List<Reservation> activeReservations =
                reservationRepository.findByUserUserIdAndActiveTrue(userId);

        for (Reservation reservation : activeReservations) {

            Restaurant restaurant = reservation.getRestaurant();

            restaurant.setCurrentDiner(
                    restaurant.getCurrentDiner() - reservation.getDiners()
            );

            restaurantRepository.save(restaurant);

            reservation.setActive(false);
            reservationRepository.save(reservation);
        }
    }
}

