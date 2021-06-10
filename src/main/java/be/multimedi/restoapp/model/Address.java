package be.multimedi.restoapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
