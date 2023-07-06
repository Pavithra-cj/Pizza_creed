package lk.nibm.scorpio.ead2.cw.pizzacreed.repository;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
