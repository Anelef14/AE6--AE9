package com.metafprestaurantexample.metafpreastaurant.application;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.metafprestaurantexample.metafpreastaurant.domain.CreateRestaurantRequest;
import com.metafprestaurantexample.metafpreastaurant.entity.Restaurant;
import com.metafprestaurantexample.metafpreastaurant.domain.RestaurantUpdateRequest;
import com.metafprestaurantexample.metafpreastaurant.infrastructure.repositories.RestaurantRepository;

@Component
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Inject
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public CreateRestaurantRequest createRestaurant (CreateRestaurantRequest createRestaurantRequest){
        Restaurant restaurant = new Restaurant(createRestaurantRequest.getName(), createRestaurantRequest.getCapacity(), createRestaurantRequest.getFoodType());
        restaurantRepository.save(restaurant);
        return createRestaurantRequest;
    }

    public CreateRestaurantRequest getRestaurant(String id) {
                UUID resId = UUID.fromString(id);
        Optional<Restaurant> restaurantOptional = getRestaurantOptional(resId);

        Restaurant fetchedRestaurant = restaurantOptional.get();
        CreateRestaurantRequest restaurant = new CreateRestaurantRequest(fetchedRestaurant.getName(), fetchedRestaurant.getCapacity(), fetchedRestaurant.getFoodType());
        return restaurant;
    }

    private Optional<Restaurant> getRestaurantOptional(UUID id) throws RuntimeException {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findByResId(id);
        if(!restaurantOptional.isPresent()){
                throw new RuntimeException();
        }
        return restaurantOptional;
    }

    public List<CreateRestaurantRequest> getAllRestaurants() {
        return restaurantRepository.findAll().stream()
    .map(r -> new CreateRestaurantRequest(r.getName(), r.getCapacity(), r.getFoodType()))
        .toList();
    }

    public CreateRestaurantRequest updateRestaurant(UUID resId, RestaurantUpdateRequest updatedData){
        Optional <Restaurant> restaurantOptional = getRestaurantOptional(resId);
        Restaurant fetchedRestaurant = restaurantOptional.get();
        fetchedRestaurant.setCapacity(updatedData.getCapacity());
        fetchedRestaurant.setFoodType(updatedData.getFoodType());
        restaurantRepository.save(fetchedRestaurant);
        CreateRestaurantRequest restaurant = new CreateRestaurantRequest(fetchedRestaurant.getName(), fetchedRestaurant.getCapacity(), fetchedRestaurant.getFoodType());
        return restaurant;
    }

        public void deleteRestaurant(String id){
        UUID resId = UUID.fromString(id);
        Optional <Restaurant> restaurantOptional = getRestaurantOptional(resId);
        Restaurant fetchedRestaurant = restaurantOptional.get();
        restaurantRepository.delete(fetchedRestaurant);
    }

}

