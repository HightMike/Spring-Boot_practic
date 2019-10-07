package ru.borisov.springwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.borisov.springwebapp.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
