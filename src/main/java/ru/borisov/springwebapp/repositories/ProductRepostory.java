package ru.borisov.springwebapp.repositories;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.borisov.springwebapp.entities.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class ProductRepostory {

    private List<Product> products;

    @PostConstruct
    public void init(){
        products =  new ArrayList<>();
        products.add(new Product(1L, "Milk", 90));
        products.add (new Product(2L, "Coffee", 120));
        products.add (new Product(5L, "Jam", 60));
    }
}
