package be.multimedi.restoapp.controller;

import be.multimedi.restoapp.model.MenuItem;
import be.multimedi.restoapp.model.Restaurant;
import be.multimedi.restoapp.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class RestaurantController {
    private RestaurantService restaurantService;


    @GetMapping("/restaurants")
    public String fetchAllRestaurants(Model model){
        model.addAttribute("restaurants",restaurantService.getAllRestaurants());
        return "restaurant-list";
    }

    @GetMapping("/restaurant/{id}")
    public String fetchRestaurantById(Model model,@PathVariable Long id){
        model.addAttribute("restaurant",restaurantService.getRestaurantById(id));
        return "restaurant-detail";
    }

    @GetMapping("/restaurant/{id}/food_menu")
    public String fetchMenuById(Model model,@PathVariable Long id){
        model.addAttribute("restaurant",restaurantService.getRestaurantById(id));
        return "food-menu";
    }

    @GetMapping("/restaurant/new")
    public String showRestaurantAddForm(Model model){
        model.addAttribute("restaurant",new Restaurant());
        return "restaurant-form";
    }

    @PostMapping("/restaurant/new")
    public String addRestaurant(@Valid Restaurant restaurant, BindingResult br){
        if (br.hasErrors()){
            return "restaurant-form";
        }else{
            restaurantService.register(restaurant);
            return "restaurant-detail";
        }
    }

    @GetMapping("/restaurant/{id}/edit")
    public String showRestaurantEditForm(Model model,@PathVariable Long id){
        model.addAttribute("restaurant",restaurantService.getRestaurantById(id));
        return "restaurant-form";
    }

    @PostMapping("/restaurant/{id}/edit")
    public String editRestaurant(Restaurant restaurant){
        restaurantService.register(restaurant);
        return "restaurant-detail";
    }

    @GetMapping("/menu-item/new")
    public String showMenuItemAddForm(Model model){
        model.addAttribute("item",new MenuItem());
        model.addAttribute("restaurants",restaurantService.getAllRestaurants());
        return "food-menu-form";
    }

    @PostMapping("/menu-item/new")
    public String addMenuItem(MenuItem menuItem){
        Restaurant restaurant = restaurantService.findRestaurantByName(menuItem.getRestaurant().getName());
        restaurantService.addMenuItemToRestaurant(menuItem,restaurant);
        return "redirect:/restaurant/" + restaurant.getId() + "/food_menu";
    }

    @GetMapping(value = "/restaurants", params = "name")
    public String fetchAllRestaurantsByName(Model model,@RequestParam(name = "name") String searchTerm){
        List<Restaurant> searchedRestaurants = restaurantService.getAllRestaurantsByName(searchTerm);
        model.addAttribute("restaurants",searchedRestaurants);
        return "restaurant-list";
    }

    @GetMapping(value = "/restaurants", params = "kitchen")
    public String fetchAllRestaurantsByKitchen(Model model, @RequestParam(name = "kitchen")String kitchen){
        List<Restaurant> searchedRestaurants = restaurantService.getAllRestaurantsByKitchen(kitchen);
        model.addAttribute("restaurants",searchedRestaurants);
        return "restaurant-list";
    }

    @GetMapping(value = "/restaurants", params = "city")
    public String fetchAllRestaurantsByCity(Model model,@RequestParam(name = "city") String city){
        List<Restaurant> searchedRestaurants = restaurantService.getAllRestaurantsByCity(city);
        model.addAttribute("restaurants",searchedRestaurants);
        return "restaurant-list";
    }
}
