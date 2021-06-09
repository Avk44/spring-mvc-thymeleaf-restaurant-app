package be.multimedi.restoapp.model;

import be.multimedi.restoapp.model.enums.MenuItemCategory;
import be.multimedi.restoapp.model.enums.MoneyType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private MenuItemCategory category;
    private Double price;
    @Column(name = "money_type")
    private MoneyType moneyType;
    @ManyToMany(mappedBy = "menu", fetch = FetchType.EAGER)
    private Set<Restaurant> restaurants = new HashSet<>();


    public void addRestaurant(Restaurant restaurant){
        restaurants.add(restaurant);
        if(!restaurant.getMenu().contains(this)) {
            restaurant.addMenuItem(this);
        }
    }
}
