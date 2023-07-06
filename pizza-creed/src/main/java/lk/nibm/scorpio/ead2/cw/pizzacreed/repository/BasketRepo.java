package lk.nibm.scorpio.ead2.cw.pizzacreed.repository;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepo extends JpaRepository<Basket, String> {

    Optional<Basket> findById(String id);

}
