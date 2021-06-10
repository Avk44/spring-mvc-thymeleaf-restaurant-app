package be.multimedi.restoapp.service;

import be.multimedi.restoapp.model.Restaurant;
import be.multimedi.restoapp.model.enums.Kitchen;
import be.multimedi.restoapp.model.enums.Star;
import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAllRestaurants();
    List<Restaurant> getAllRestaurantsByKitchen(Kitchen kitchen);
    List<Restaurant> getAllRestaurantsByStar(Star review);
    void register(Restaurant restaurant);
    Restaurant getRestaurantById(Long id);

}
