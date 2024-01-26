package coffeeshop.coffeeshop.service;


import coffeeshop.coffeeshop.entity.Category;
import coffeeshop.coffeeshop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory(){

        return categoryRepository.findAll();
    }

}
