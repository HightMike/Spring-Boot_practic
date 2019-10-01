package ru.borisov.springwebapp.services;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.borisov.springwebapp.entities.Product;
import ru.borisov.springwebapp.repositories.ProductRepostory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class ProductService {

    private ProductRepostory productRepostory;

    @Autowired
    public void setProductRepository(ProductRepostory productRepostory) {
        this.productRepostory = productRepostory;
    }

    public List<Product> getAllProducts() {
        return productRepostory.getProducts();
    }

    public Product getProductById(Long id) {
        return productRepostory.getProducts().get(id.intValue()-1);
    }
}
