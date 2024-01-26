package coffeeshop.coffeeshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, max = 15, message = "The value of the username field must be in the range from 5 to 15 characters")
    private String username;
    @Size(min = 5, message = "The value of the username field must be greater than 5 characters")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Roles> rolesset;
}
