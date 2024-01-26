package coffeeshop.coffeeshop.service;


import coffeeshop.coffeeshop.entity.Category;
import coffeeshop.coffeeshop.entity.Product;
import coffeeshop.coffeeshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

private final ProductRepository productRepository;


public List<Product> findProductsByCategory(Category category)
{

return productRepository.findAllByCategories(category);
}


}
