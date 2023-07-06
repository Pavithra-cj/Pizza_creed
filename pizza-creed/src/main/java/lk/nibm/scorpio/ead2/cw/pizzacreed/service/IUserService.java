package lk.nibm.scorpio.ead2.cw.pizzacreed.service;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.User;

public interface IUserService {

    User findByUsername(String username);

    User save(User user);

}
