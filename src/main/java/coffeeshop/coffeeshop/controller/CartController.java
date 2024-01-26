package coffeeshop.coffeeshop.controller;


import coffeeshop.coffeeshop.bl.Cart;
import coffeeshop.coffeeshop.bl.ItemCart;
import coffeeshop.coffeeshop.entity.Clients;
import coffeeshop.coffeeshop.entity.Order;
import coffeeshop.coffeeshop.entity.Product;
import coffeeshop.coffeeshop.entity.ProductHasOrder;
import coffeeshop.coffeeshop.repository.ClientsRepository;
import coffeeshop.coffeeshop.repository.OrderRepository;
import coffeeshop.coffeeshop.repository.ProductHasOrderRepository;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequiredArgsConstructor


public class CartController {

    private final ClientsRepository clientsRepository;
    private final OrderRepository orderRepository;
    private final ProductHasOrderRepository productHasOrderRepository;

    @GetMapping("/cart")
    public String getPageCart(HttpServletRequest request,
                              Model model ){

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart==null){
            cart = new Cart();
        }
        model.addAttribute("cart", cart.getCart());
        model.addAttribute("total", cart.getTotalValue());
        model.addAttribute("sum", cart.getSumItem());


        return "cart";
    }

    @PostMapping("/addItemToCart")
    public String saveNewItemToCart(@RequestParam(name="id") Product product,
                                    @RequestParam(name="quantity") int quantity,
                                    HttpServletRequest request

    )

    {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart==null) cart = new Cart();

        cart.addNewItemToCart(product, quantity);
        session.setAttribute("cart", cart);



        return "redirect:/cart";
    }

    @PostMapping("/updateProductFromCart")
    public String updateProductByCart(@RequestParam(name = "id") Product product,
                                      @RequestParam(name = "quantity") int quantity,
                                      HttpServletRequest request) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        cart.updateItemFromCart(product, quantity);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @PostMapping("/deleteProductFromCart")
    public String deleteItemFromCart(@RequestParam(name = "id") Product product,
                                     HttpServletRequest request) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        cart.deleteItemCart(product);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @PostMapping("/deleteAllProductFromCart")
    public String deleteAllProductFromCart(HttpServletRequest request){

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart==null) cart = new Cart();
        cart.deleteAllItemCart();
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @GetMapping("/order")
    public String getPageOrder(HttpServletRequest request,
                               Model model
    ){

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null){
            cart = new Cart();
        }

        Long id = (Long) session.getAttribute("user");
        Clients client = clientsRepository.findById(id).get();

        model.addAttribute("client", client);
        model.addAttribute("cart", cart.getCart());
        model.addAttribute("total", cart.getTotalValue());

        return "order";
    }


    @PostMapping("/buy")
    public String buyProduct(@RequestParam(name = "payment") String payment,
                             @RequestParam(name = "delivery") String delivery,
                             HttpServletRequest request
    ){

            String payment1 = "";
            payment1 = (payment.equals("1")) ? "Money" : "Money payment";

            String delivery1 = "";
            if (delivery.equals("1")) {
                delivery1 = "Department #1";
            } else if (delivery.equals("2")) {
                delivery1 = "Department #2";
            } else {
                delivery1 = "Department #3";
            }

            HttpSession session = request.getSession();

            Long id = (Long) session.getAttribute("user");
            Cart cart = (Cart) session.getAttribute("cart");

            if (cart == null) return "redirect:/category";
            Clients client = null;

            if (id != null) {

                client = clientsRepository.findById(id).get();

                Order order = new Order();
                order.setClientes(client);
                order.setDateCreated(new Date());
                order.setPayment(payment1);
                order.setDelivery(delivery1);

                Order order1 = orderRepository.save(order);

            for (ItemCart el : cart.getCart()) {
                productHasOrderRepository.save(new ProductHasOrder(el.getProduct(), order1, el.getQuantity()));
            }

            cart.deleteAllItemCart();
            session.setAttribute("cart", cart);

            return "redirect:/thank";
        } else {
            return "redirect:/category";
        }
    }
    @GetMapping("/thank")
    public String getPageThank(){
        return "thank";
    }
}
