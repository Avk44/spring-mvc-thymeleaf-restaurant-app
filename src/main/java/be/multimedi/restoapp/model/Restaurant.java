package be.multimedi.restoapp.model;

import be.multimedi.restoapp.model.enums.Kitchen;
import be.multimedi.restoapp.model.enums.Star;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Star review;
    private String photoUrl;
    @Enumerated(value = EnumType.STRING)
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
