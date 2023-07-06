package lk.nibm.scorpio.ead2.cw.pizzacreed.repository;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketItemRepo extends JpaRepository<BasketItem, Long>{
}
