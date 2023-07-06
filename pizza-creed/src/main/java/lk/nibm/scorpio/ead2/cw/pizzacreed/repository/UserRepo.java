package lk.nibm.scorpio.ead2.cw.pizzacreed.repository;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
