package coffeeshop.coffeeshop.repository;

import coffeeshop.coffeeshop.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
