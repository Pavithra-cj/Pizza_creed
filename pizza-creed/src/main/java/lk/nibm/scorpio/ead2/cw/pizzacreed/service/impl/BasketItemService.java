package lk.nibm.scorpio.ead2.cw.pizzacreed.service.impl;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.BasketItem;
import lk.nibm.scorpio.ead2.cw.pizzacreed.service.IBasketItemService;
import lk.nibm.scorpio.ead2.cw.pizzacreed.repository.BasketItemRepo;
import lk.nibm.scorpio.ead2.cw.pizzacreed.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasketItemService implements IBasketItemService {

    public Double cost = 0.0;

    @Autowired
    private BasketItemRepo basketItemRepo;

    @Autowired
    private ProductRepo productRepo;

    //method for save new Basket Item
    @Override
    public String saveBasket(BasketItem basketItem) {
        basketItemRepo.save(basketItem);
        return "New Basket Item Added";
    }

    //method for get all basket Items
    @Override
    public List<BasketItem> getAllBaskets() {
        return basketItemRepo.findAll();
    }

    //method for cost zero
    @Override
    public void clearCart() {
        cost=0.0;
    }

    //delete basket Items by Id
    @Override
    public boolean deleteBasketById(Long basketId) {
        Optional<BasketItem> basketOptional = basketItemRepo.findById(basketId);
        if (basketOptional.isPresent()) {
            BasketItem basket = basketOptional.get();
            basketItemRepo.delete(basket);
            return true;
        }
        return false;
    }

    //delete all basket Items (clear cart)
    @Override
    public boolean deleteAllBasketItems() {
        try {
            basketItemRepo.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
