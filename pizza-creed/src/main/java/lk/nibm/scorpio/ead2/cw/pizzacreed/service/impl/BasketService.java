package lk.nibm.scorpio.ead2.cw.pizzacreed.service.impl;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.Basket;
import lk.nibm.scorpio.ead2.cw.pizzacreed.service.IBasketItemService;
import lk.nibm.scorpio.ead2.cw.pizzacreed.repository.BasketRepo;
import lk.nibm.scorpio.ead2.cw.pizzacreed.service.IBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService implements IBasketService {

    @Autowired
    private BasketRepo basketRepo;

    //method for create new basket method 01
    @Override
    public Basket createBasket(Basket basket1) {
        Basket createdBasket = basketRepo.save(basket1);
        //return createdBasket.getId();
        return createdBasket;
    }

    //method for create new basket method 02
    @Override
    public Basket createBasket() {
        Basket basket = new Basket();
        return basketRepo.save(basket);
    }
    //method for read all baskets
    @Override
    public List<Basket> findallBaskets() {
        return basketRepo.findAll();
    }

}
