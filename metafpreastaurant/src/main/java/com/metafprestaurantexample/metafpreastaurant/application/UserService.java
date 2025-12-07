package com.metafprestaurantexample.metafpreastaurant.application;

import com.metafprestaurantexample.metafpreastaurant.dto.RestaurantDto;
import com.metafprestaurantexample.metafpreastaurant.dto.UserDto;
import com.metafprestaurantexample.metafpreastaurant.entity.Restaurant;
import com.metafprestaurantexample.metafpreastaurant.entity.User;
import com.metafprestaurantexample.metafpreastaurant.infrastructure.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserDto createUserRequest){
        User user = new User(createUserRequest.getName(), createUserRequest.getEmailAddress());
        userRepository.save(user);
        return createUserRequest;
    }

    public UserDto getUser(String id){
        UUID userId = UUID.fromString(id);
        Optional<User> userOptional = getUserOptional(userId);

        User fetchedUser = userOptional.get();
        UserDto user = new UserDto(fetchedUser.getUserId(), fetchedUser.getName(), fetchedUser.getEmail());
        return user;
    }

    private Optional<User> getUserOptional(UUID id) throws RuntimeException {
        Optional<User> userOptional = userRepository.findByUserId(id);
        if(!userOptional.isPresent()){
            throw new RuntimeException();
        }
        return userOptional;
    }

    public List<UserDto> getAllUsers( ){
        return userRepository.findAll().stream()
                .map(u -> new UserDto(u.getUserId(), u.getName(), u.getEmail()))
                .toList();
    }

    public void deleteUser(String id){
        UUID userId = UUID.fromString(id);
        Optional <User> userOptional = getUserOptional(userId);
        User fetchedUser = userOptional.get();
        userRepository.delete(fetchedUser);
    }
}
