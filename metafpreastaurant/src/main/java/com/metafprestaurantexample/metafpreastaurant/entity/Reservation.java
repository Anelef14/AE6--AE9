package com.metafprestaurantexample.metafpreastaurant.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @NotNull(message = "User is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull(message = "Restaurant is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @NotNull(message = "Number of diners is required")
    @Min(value = 1, message = "Number of diners should be at least 1")
    @Column(name = "number_of_diners", nullable = false)
    private Integer numberOfDiners;

    @Column(nullable = false)
    private Boolean active = true;

    public Reservation(User user, Restaurant restaurant, Integer numberOfDiners) {
        this.user = user;
        this.restaurant = restaurant;
        this.numberOfDiners = numberOfDiners;
    }

    public Reservation() {
        this.active= true;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getNumberOfDiners() {
        return numberOfDiners;
    }

    public void setNumberOfDiners(Integer numberOfDiners) {
        this.numberOfDiners = numberOfDiners;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
