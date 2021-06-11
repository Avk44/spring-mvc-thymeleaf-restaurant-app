package be.multimedi.restoapp.model;

import be.multimedi.restoapp.model.enums.MenuItemCategory;
import be.multimedi.restoapp.model.enums.MoneyType;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photoUrl;
    @Enumerated(value = EnumType.STRING)
    private MenuItemCategory category;
    private Double price;
    @Column(name = "money_type")
    @Enumerated(value = EnumType.STRING)
    private MoneyType moneyType;
    @ManyToOne()
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", moneyType=" + moneyType +
                '}';
    }
}
