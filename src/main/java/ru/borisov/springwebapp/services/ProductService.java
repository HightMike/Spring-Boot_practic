package ru.borisov.springwebapp.services;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.borisov.springwebapp.entities.Product;
import ru.borisov.springwebapp.repositories.ProductRepository;

import java.util.List;

@Getter
@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public Product getProductByTitle(String title) {
        return productRepository.findOneByTitle(title);
    }

}
