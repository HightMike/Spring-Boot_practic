package ru.borisov.springwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.borisov.springwebapp.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findOneByTitle(String title);

}
