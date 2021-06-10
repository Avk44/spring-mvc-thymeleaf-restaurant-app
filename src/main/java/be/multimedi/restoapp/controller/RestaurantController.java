package be.multimedi.restoapp.controller;


import be.multimedi.restoapp.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class RestaurantController {
    private RestaurantService restaurantService;


    @GetMapping("/restaurants")
    public String fetchAllRestaurants(Model model){
        model.addAttribute("restaurants",restaurantService.getAllRestaurants());
        return "restaurant-list";
    }
}
