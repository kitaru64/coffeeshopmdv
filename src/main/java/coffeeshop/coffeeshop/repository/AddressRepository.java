package coffeeshop.coffeeshop.repository;

import coffeeshop.coffeeshop.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
