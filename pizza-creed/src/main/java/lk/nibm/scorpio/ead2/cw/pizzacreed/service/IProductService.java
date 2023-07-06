package lk.nibm.scorpio.ead2.cw.pizzacreed.service;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product save(Product product);

    Product find(Long id);

    boolean delete(Long id);

}
