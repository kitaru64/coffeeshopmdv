package coffeeshop.coffeeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateCreated;
    private boolean statusOrder;
    private String delivery;
    private String payment;


    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private Clients clientes;

    @OneToMany(mappedBy = "ordere")
    private List<ProductHasOrder> productHasOrders;

}
