package com.metafprestaurantexample.metafpreastaurant.application;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;

import jakarta.transaction.Transactional;

import com.metafprestaurantexample.metafpreastaurant.dto.RestaurantDto;
import com.metafprestaurantexample.metafpreastaurant.entity.Restaurant;
import com.metafprestaurantexample.metafpreastaurant.domain.RestaurantUpdateRequest;
import com.metafprestaurantexample.metafpreastaurant.domain.RestaurantCreateRequest;
import com.metafprestaurantexample.metafpreastaurant.infrastructure.repositories.RestaurantRepository;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Inject
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantCreateRequest createRestaurant (RestaurantCreateRequest createRestaurantRequest){
        Restaurant restaurant = new Restaurant(createRestaurantRequest.getName(), createRestaurantRequest.getCapacity(), createRestaurantRequest.getFoodType(), createRestaurantRequest.getCurrentDiners());
        restaurantRepository.save(restaurant);
        return createRestaurantRequest;
    }

    public RestaurantDto getRestaurant(String id) {
        UUID resId = UUID.fromString(id);
        Optional<Restaurant> restaurantOptional = getRestaurantOptional(resId);

        Restaurant fetchedRestaurant = restaurantOptional.get();
        RestaurantDto restaurant = new RestaurantDto(fetchedRestaurant.getResId(), fetchedRestaurant.getName(), fetchedRestaurant.getCapacity(), fetchedRestaurant.getFoodType(), fetchedRestaurant.getCurrentDiner());
        return restaurant;
    }

    private Optional<Restaurant> getRestaurantOptional(UUID id) throws RuntimeException {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findByResId(id);
        if(!restaurantOptional.isPresent()){
                throw new RuntimeException();
        }
        return restaurantOptional;
    }

    public List<RestaurantDto> getAllRestaurants() {
        return restaurantRepository.findAll().stream()
    .map(r -> new RestaurantDto(r.getResId(), r.getName(), r.getCapacity(), r.getFoodType(), r.getCurrentDiner()))
        .toList();
    }

    public RestaurantDto updateRestaurant(UUID resId, RestaurantUpdateRequest updatedData){
        Optional <Restaurant> restaurantOptional = getRestaurantOptional(resId);
        Restaurant fetchedRestaurant = restaurantOptional.get();
        fetchedRestaurant.setCapacity(updatedData.getCapacity());
        fetchedRestaurant.setFoodType(updatedData.getFoodType());
        restaurantRepository.save(fetchedRestaurant);
        RestaurantDto restaurant = new RestaurantDto(fetchedRestaurant.getResId(), fetchedRestaurant.getName(), fetchedRestaurant.getCapacity(), fetchedRestaurant.getFoodType(), fetchedRestaurant.getCurrentDiner());
        return restaurant;
    }

        public void deleteRestaurant(String id){
        UUID resId = UUID.fromString(id);
        Optional <Restaurant> restaurantOptional = getRestaurantOptional(resId);
        Restaurant fetchedRestaurant = restaurantOptional.get();
        restaurantRepository.delete(fetchedRestaurant);
    }

}

