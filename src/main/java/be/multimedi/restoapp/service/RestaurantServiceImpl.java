package be.multimedi.restoapp.service;

import be.multimedi.restoapp.model.MenuItem;
import be.multimedi.restoapp.model.Restaurant;
import be.multimedi.restoapp.model.enums.Kitchen;
import be.multimedi.restoapp.model.enums.Star;
import be.multimedi.restoapp.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository restaurantRepository;


    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getAllRestaurantsByKitchen(Kitchen kitchen) {
        return restaurantRepository.findRestaurantsByKitchen(kitchen);
    }

    @Override
    public List<Restaurant> getAllRestaurantsByStar(Star review) {
        return restaurantRepository.findRestaurantsByReview(review);
    }

    @Override
    public void register(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.getById(id);
    }

    @Override
    public void addMenuItemToRestaurant(MenuItem menuItem, Restaurant restaurant) {
        Restaurant updatedRestaurant = Restaurant.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .photoUrl(restaurant.getPhotoUrl())
                .review(restaurant.getReview())
                .kitchen(restaurant.getKitchen())
                .menu(restaurant.getMenu())
                .address(restaurant.getAddress())
                .build();
        updatedRestaurant.addMenuItem(menuItem);
        register(updatedRestaurant);
    }

    @Override
    public Restaurant findRestaurantByName(String name) {
        return restaurantRepository.findRestaurantByName(name);
    }
}
