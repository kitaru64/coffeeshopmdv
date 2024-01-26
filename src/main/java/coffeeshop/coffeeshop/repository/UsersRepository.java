package coffeeshop.coffeeshop.repository;

import coffeeshop.coffeeshop.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByUsername(String username);

    List<Users> findAllByUsernameAndPassword(String user, String pass);

}
