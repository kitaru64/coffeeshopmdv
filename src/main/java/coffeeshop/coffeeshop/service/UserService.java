package coffeeshop.coffeeshop.service;

import coffeeshop.coffeeshop.entity.Users;
import coffeeshop.coffeeshop.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    public boolean getLogicUserByUsername(String username){

        return (!usersRepository.findAllByUsername(username).isEmpty()) ? true : false;
    }

    public boolean getLogicUserByUsernameAndPassword(String username, String password){


        return usersRepository.findAllByUsernameAndPassword(username, password).isEmpty() ? true : false;
    }

    public Users getUserByUsernameAndPassword(String username, String password){

        return usersRepository.findAllByUsernameAndPassword(username, password).get(0);
    }


}