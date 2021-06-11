package be.multimedi.restoapp.repository;

import be.multimedi.restoapp.model.Restaurant;
import be.multimedi.restoapp.model.enums.Kitchen;
import be.multimedi.restoapp.model.enums.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    List<Restaurant> findRestaurantsByKitchen(Kitchen kitchen);
    List<Restaurant> findRestaurantsByReview(Star review);
    Restaurant findRestaurantByName(String name);
}
