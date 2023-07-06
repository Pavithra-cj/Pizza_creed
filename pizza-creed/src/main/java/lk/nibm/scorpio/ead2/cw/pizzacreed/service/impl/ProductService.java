package lk.nibm.scorpio.ead2.cw.pizzacreed.service.impl;

import lk.nibm.scorpio.ead2.cw.pizzacreed.model.Product;
import lk.nibm.scorpio.ead2.cw.pizzacreed.repository.ProductRepo;
import lk.nibm.scorpio.ead2.cw.pizzacreed.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepo productRepo;

    //method for rest controller for save products
    @Override
    public Product save(Product product) {
        Product dto = null;
        if(product.getId() == null){
            dto = new Product();
        }else{
            Optional<Product> optionalProduct = productRepo.findById(product.getId());
            if(optionalProduct.isPresent()){
                dto = optionalProduct.get();
            }
        }
        BeanUtils.copyProperties(product,dto);
        dto = productRepo.save(dto);
        product.setId(dto.getId());
        return product;
    }

    //method for rest controller for find all products
    @Override
    public List<Product> findAll() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(s ->{
            Product dto = new Product();
            BeanUtils.copyProperties(s,dto);
            return dto;
        }).collect(Collectors.toList());
    }

    //method for rest controller for find products by id
    @Override
    public Product find(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()){
            Product dto = new Product();
            BeanUtils.copyProperties(optionalProduct.get(),dto);
            return dto;
        }
        return null;
    }

    //method for rest controller for delete product
    @Override
    public boolean delete(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            productRepo.delete(optionalProduct.get());
        }else {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    //method for list all products in GUI Table
    public List<Product> listAll() {
        return  productRepo.findAll();
    }

    //method for get product by id in GUI Table
    public Product get(long id) {
        return productRepo.findById(id).get();
    }

    //method for delete products in GUI Table
    public void deleteProducts(long id) {
        productRepo.deleteById(id);
    }

    //method for save product in GUI Table
    public void saveProducts(Product std) {
        productRepo.save(std);
    }

}
