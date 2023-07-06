package lk.nibm.scorpio.ead2.cw.pizzacreed.service;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.BasketItem;

import java.util.List;

public interface IBasketItemService {

    //List<BasketItem> findAll();

    //save basket items
    String saveBasket(BasketItem basketItem);

    //get all baskets items
    List<BasketItem> getAllBaskets();

    void clearCart();

    //delete basket item by id
    boolean deleteBasketById(Long basketId);

    //method for delete all basket item
    boolean deleteAllBasketItems();

}
