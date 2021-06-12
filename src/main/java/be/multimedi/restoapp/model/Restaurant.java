package be.multimedi.restoapp.model;

import be.multimedi.restoapp.model.enums.Kitchen;
import be.multimedi.restoapp.model.enums.Star;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private String name;
    private Star review;
    @NotBlank
    private String photoUrl;
    @Enumerated(value = EnumType.STRING)
    private Kitchen kitchen;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    private Set<MenuItem> menu = new HashSet<>();

    public void addMenuItem(MenuItem menuItem){
        this.menu.add(menuItem);
    }


}
