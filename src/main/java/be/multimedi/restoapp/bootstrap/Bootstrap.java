package be.multimedi.restoapp.bootstrap;

import be.multimedi.restoapp.model.Address;
import be.multimedi.restoapp.model.MenuItem;
import be.multimedi.restoapp.model.Restaurant;
import be.multimedi.restoapp.model.enums.Kitchen;
import be.multimedi.restoapp.model.enums.MenuItemCategory;
import be.multimedi.restoapp.model.enums.MoneyType;
import be.multimedi.restoapp.model.enums.Star;
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
        Address address1 = Address.builder()
                .street("Rijksweg")
                .number(215)
                .postcode("3630")
                .city("Maasmechelen")
                .country("Belgium").build();

        Restaurant restaurant = Restaurant.builder()
                .name("Ali Baba")
                .kitchen(Kitchen.TURKISH)
                .review(Star.FOUR)
                .photoUrl("https://i.pinimg.com/originals/e6/fa/e5/e6fae5f62420412c28ea61eb0abd1082.jpg")
                .address(address)
                .menu(new HashSet<>())
                .build();


        Restaurant restaurant1 = Restaurant.builder()
                .name("Giuliano")
                .kitchen(Kitchen.ITALIAN)
                .review(Star.FIVE)
                .photoUrl("https://www.ahstatic.com/photos/a5e9_rsr005_00_p_1024x768.jpg")
                .address(address1)
                .menu(new HashSet<>())
                .build();


        MenuItem menuItem = MenuItem.builder()
                .name("Kebap")
                .category(MenuItemCategory.GRILL)
                .photoUrl("https://media-cdn.tripadvisor.com/media/photo-s/0e/4e/e4/7e/tavuk-kizartma-sogan.jpg")
                .price(15.00)
                .moneyType(MoneyType.EURO)
                .restaurant(restaurant)
                .build();

        MenuItem menuItem1 = MenuItem.builder()
                .name("Spaghetti")
                .category(MenuItemCategory.MAIN_COURSE)
                .photoUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR96xVtGipWb3y2lBrSBz-j-j3p44AjQXz-SAdVmxmR84IYtK0DQd26ncDcVeV8LkxxnPQ&usqp=CAU")
                .price(14.50)
                .moneyType(MoneyType.EURO)
                .restaurant(restaurant1)
                .build();


        restaurant.addMenuItem(menuItem);
        restaurantService.register(restaurant);
        restaurant1.addMenuItem(menuItem1);
        restaurantService.register(restaurant1);
    }
}
