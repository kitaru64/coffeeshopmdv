package coffeeshop.coffeeshop.bl;


import coffeeshop.coffeeshop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ItemCart {

    private Product product;
    private int quantity;

}
