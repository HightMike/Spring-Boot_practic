package ru.borisov.springwebapp.services;


import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.borisov.springwebapp.entities.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class ProductService {

    private List<Product> products;

    @PostConstruct
    public void init(){
        products =  new ArrayList<>();
        products.add(new Product(1L, "Milk", 90));
        products.add (new Product(2L, "Coffee", 120));
        products.add (new Product(5L, "Jam", 60));
    }

}
