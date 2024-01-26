package coffeeshop.coffeeshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 55, message = "The value of the username field must be in the range from 2 to 55 characters")
    private String firstName;
    @Size(min = 2, max = 55, message = "The value of the username field must be in the range from 2 to 15 characters")
    private String lastName;
    @Email(message = "The incorrect form of email")
    private String email;
    private int phone;
    private int age;

    @OneToOne
    @MapsId
    @MapKey
    @JoinColumn(name = "id")
    private Users user;


    @OneToMany(mappedBy="cliente")
    private List<Address> addressList;

    @OneToMany(mappedBy="clientes")
    private List<Order> orderList;
}
