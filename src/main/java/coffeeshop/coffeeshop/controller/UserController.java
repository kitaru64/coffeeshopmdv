package coffeeshop.coffeeshop.controller;

import coffeeshop.coffeeshop.entity.Clients;
import coffeeshop.coffeeshop.entity.Roles;
import coffeeshop.coffeeshop.entity.Users;
import coffeeshop.coffeeshop.repository.ClientsRepository;
import coffeeshop.coffeeshop.repository.UsersRepository;
import coffeeshop.coffeeshop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UsersRepository usersRepository;
    private final ClientsRepository clientsRepository;
    private final UserService userService;

    @GetMapping("/registration")
    public String getPageRegistration(Model model) {

        model.addAttribute("users", new Users());
        model.addAttribute("clients", new Clients());

        return "registration";
    }


    @PostMapping("/registration")
    public String saveNewUserToDB(@Valid Users user,
                                  BindingResult bindingResult1,
                                  @Valid Clients client,
                                  BindingResult bindingResult2
    ) {

        if (bindingResult1.hasErrors()) {
            return "registration";
        }

        if (bindingResult2.hasErrors()) {
            return "registration";
        }

        if (userService.getLogicUserByUsername(user.getUsername())) {
            return "registration";
        }



        user.setRolesset(Collections.singleton(new Roles(1L, "ROLE_Users")));

        Users user1 = usersRepository.save(user);
        client.setUser(user1);
        clientsRepository.save(client);


        return "redirect:/login";
    }

    @PostMapping("/login")
    public String authUser(@RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String pass,
                           HttpServletRequest request) {


        if(userService.getLogicUserByUsernameAndPassword(username, pass)){

            return "redirect:/login";

        } else {

            Users user = userService.getUserByUsernameAndPassword(username, pass);
            HttpSession session = request.getSession();
            session.setAttribute("user", user.getId());

            return "redirect:/order";
        }
    }

}
