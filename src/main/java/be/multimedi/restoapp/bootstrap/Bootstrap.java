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
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashSet;

@Component
@AllArgsConstructor
@Profile("test")
public class Bootstrap {
    private RestaurantService restaurantService;

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

        Address address2 = Address.builder()
                .street("Koningennelaan")
                .number(315)
                .postcode("1090")
                .city("Brussels")
                .country("Belgium").build();

        Address address3 = Address.builder()
                .street("Bergstraat")
                .number(25)
                .postcode("5040")
                .city("Liege")
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

        Restaurant restaurant2 = Restaurant.builder()
                .name("Sy Le Man")
                .kitchen(Kitchen.CHINA)
                .review(Star.THREE)
                .photoUrl("https://media-cdn.tripadvisor.com/media/photo-s/06/5f/dc/bb/the-best-chinese-restaurant.jpg")
                .address(address2)
                .menu(new HashSet<>())
                .build();


        Restaurant restaurant3 = Restaurant.builder()
                .name("Naveena")
                .kitchen(Kitchen.INDIAN)
                .review(Star.FOUR)
                .photoUrl("https://archello.s3.eu-central-1.amazonaws.com/images/2020/08/22/" +
                        "comelite-architecture-structure-and-interior-design-naveena-modern-indian-" +
                        "restaurant-design-restaurants-archello.1598087893.9613.jpg")
                .address(address3)
                .menu(new HashSet<>())
                .build();

        MenuItem water = MenuItem.builder()
                .name("Water")
                .category(MenuItemCategory.DRINK)
                .photoUrl("https://www.spa.be/img/home/product-water-group.png")
                .price(2.00)
                .moneyType(MoneyType.EURO)
                .restaurant(restaurant)
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

        MenuItem menuItem2 = MenuItem.builder()
                .name("Sichuan Pork")
                .category(MenuItemCategory.MAIN_COURSE)
                .photoUrl("https://images.chinahighlights.com/allpicture/2019/11/7b3afb974d7946bbbe397f7c_894x670.webp")
                .price(19.00)
                .moneyType(MoneyType.EURO)
                .restaurant(restaurant2)
                .build();

        MenuItem menuItem3 = MenuItem.builder()
                .name("Murgh Makhani (Butter Chicken)")
                .category(MenuItemCategory.MAIN_COURSE)
                .photoUrl("https://www.thespruceeats.com/thmb/kdJ6PSTpUOrMY5X-emab0g-CL40=" +
                        "/1728x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)" +
                        "/authentic-butter-chicken-1957382-Hero-5b61b398c9e77c0050160f54.jpg")
                .price(17.50)
                .moneyType(MoneyType.EURO)
                .restaurant(restaurant3)
                .build();


        restaurant.addMenuItem(menuItem);
        restaurant1.addMenuItem(menuItem1);
        restaurant2.addMenuItem(menuItem2);
        restaurant3.addMenuItem(menuItem3);
        restaurant.addMenuItem(water);
        restaurantService.register(restaurant);
        restaurantService.register(restaurant1);
        restaurantService.register(restaurant2);
        restaurantService.register(restaurant3);
    }
}
