package be.multimedi.restoapp.bootstrap;

import be.multimedi.restoapp.model.Address;
import be.multimedi.restoapp.model.MenuItem;
import be.multimedi.restoapp.model.Restaurant;
import be.multimedi.restoapp.model.enums.Kitchen;
import be.multimedi.restoapp.model.enums.MenuItemCategory;
import be.multimedi.restoapp.model.enums.MoneyType;
import be.multimedi.restoapp.model.enums.Star;
import be.multimedi.restoapp.service.MenuItemService;
import be.multimedi.restoapp.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@Component
@AllArgsConstructor
public class Bootstrap {
    private RestaurantService restaurantService;
    private MenuItemService menuItemService;

    @PostConstruct
    public void init(){

        Address address = Address.builder()
                .street("Stalen straat")
                .number(45)
                .postcode("3600")
                .city("Genk")
                .country("Belgium").build();

        MenuItem menuItem = MenuItem.builder()
                .name("Kebap")
                .category(MenuItemCategory.GRILL)
                .price(15.00)
                .moneyType(MoneyType.EURO)
                .restaurants(new HashSet<>())
                .build();

        menuItemService.register(menuItem);

        Restaurant restaurant = Restaurant.builder()
                .name("Ali Baba")
                .kitchen(Kitchen.TURKISH)
                .review(Star.FOUR)
                .address(address)
                .menu(new HashSet<>())
                .build();

        restaurant.addMenuItem(menuItem);

        restaurantService.register(restaurant);
    }
}
