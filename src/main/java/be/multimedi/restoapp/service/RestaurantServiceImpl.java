package be.multimedi.restoapp.service;

import be.multimedi.restoapp.model.MenuItem;
import be.multimedi.restoapp.model.Restaurant;
import be.multimedi.restoapp.model.enums.Kitchen;
import be.multimedi.restoapp.model.enums.Star;
import be.multimedi.restoapp.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Restaurant> getAllRestaurantsByKitchen(String kitchen) {
        List<Restaurant> restaurants = new ArrayList<>();
        for (Kitchen kitchen1: Kitchen.values()) {
            if (kitchen1.name().equalsIgnoreCase(kitchen)){
                restaurants = restaurantRepository.findRestaurantsByKitchen(Kitchen.valueOf(kitchen.toUpperCase()));
            }
        }

        return restaurants;
    }

    @Override
    public List<Restaurant> getAllRestaurantsByCity(String city) {
        return restaurantRepository.findRestaurantsByAddress_CityIgnoreCase(city);
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
        restaurant.addMenuItem(menuItem);
        register(restaurant);
    }

    @Override
    public Restaurant findRestaurantByName(String name) {
        return restaurantRepository.findRestaurantByName(name);
    }

    @Override
    public List<Restaurant> getAllRestaurantsByName(String searchTerm) {
        return restaurantRepository.findRestaurantsByNameIgnoreCaseIsLike("%" + searchTerm + "%");
    }
}
