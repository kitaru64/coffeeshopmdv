package coffeeshop.coffeeshop.repository;

import coffeeshop.coffeeshop.entity.Category;
import coffeeshop.coffeeshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategories(Category category);
    List<Product> findAllByNameOrderByName(String name);
    List<Product> findAllByNameContainsIgnoreCaseOrderByName(String name);

}
