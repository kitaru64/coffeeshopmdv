package coffeeshop.coffeeshop.repository;

import coffeeshop.coffeeshop.entity.Attribute;
import org.aspectj.apache.bcel.classfile.AttributeUtils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}
