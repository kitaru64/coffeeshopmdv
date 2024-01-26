package coffeeshop.coffeeshop.repository;

import coffeeshop.coffeeshop.entity.ProductHasOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductHasOrderRepository extends JpaRepository<ProductHasOrder, Long> {
}
