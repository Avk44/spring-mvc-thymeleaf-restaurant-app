package be.multimedi.restoapp.service;

import be.multimedi.restoapp.model.MenuItem;
import be.multimedi.restoapp.model.Restaurant;
import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    List<Restaurant> getAllRestaurantsByKitchen(String kitchen);
    List<Restaurant> getAllRestaurantsByCity(String city);
    void register(Restaurant restaurant);
    Restaurant getRestaurantById(Long id);
    void addMenuItemToRestaurant(MenuItem menuItem,Restaurant restaurant);
    Restaurant findRestaurantByName(String name);
    List<Restaurant> getAllRestaurantsByName(String searchTerm);
}
