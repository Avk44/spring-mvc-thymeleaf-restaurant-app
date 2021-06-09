package be.multimedi.restoapp.model;

import be.multimedi.restoapp.model.enums.Kitchen;
import be.multimedi.restoapp.model.enums.Star;
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
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Star review;
    private Kitchen kitchen;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "Restaurant_menu_item",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id"))
    private Set<MenuItem> menu = new HashSet<>();

    public void addMenuItem(MenuItem menuItem){
        this.menu.add(menuItem);
        if(!menuItem.getRestaurants().contains(this)){
            menuItem.addRestaurant(this);
        }
    }
}
