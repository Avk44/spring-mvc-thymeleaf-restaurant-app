package be.multimedi.restoapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;
    private String postcode;
    private String city;
    private String country;
    @OneToOne(mappedBy = "address")
    private Restaurant restaurant;

}
