package lk.nibm.scorpio.ead2.cw.pizzacreed.service;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.Basket;

import java.util.List;

public interface IBasketService {

    Basket createBasket(Basket basket1);
    List<Basket> findallBaskets();
    Basket createBasket();

}
