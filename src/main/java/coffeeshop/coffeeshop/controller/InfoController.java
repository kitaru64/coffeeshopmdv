package coffeeshop.coffeeshop.controller;

import coffeeshop.coffeeshop.entity.Category;
import coffeeshop.coffeeshop.repository.ProductRepository;
import coffeeshop.coffeeshop.service.CategoryService;
import coffeeshop.coffeeshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class InfoController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping("/payment")
    public String getPagePayment(){
        return "payment";
    }
    @GetMapping("/delivery")
    public String getPageDelivery(){
        return "delivery";
    }
    @GetMapping("/aboutus")
    public String getPageInfo(){
        return "info";
    }
    @GetMapping("/login")
    public String getPageLogin(){
        return "aunth";
    }
    @GetMapping("/category")
    public String getPageCategory(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());

        return "category";
    }

    @GetMapping("/category/{id}")
    public String getProductsByCategory(@PathVariable("id") Category category, Model model){


        model.addAttribute("productByCategory", productService.findProductsByCategory(category));
        return "products";
    }
    @GetMapping("/search")
    public String getPageResultSearchProductByName(@RequestParam(name = "search") String name,
                                                   Model model){

        model.addAttribute("productByName", productRepository.findAllByNameContainsIgnoreCaseOrderByName(name));

        return "search";
    }


}
