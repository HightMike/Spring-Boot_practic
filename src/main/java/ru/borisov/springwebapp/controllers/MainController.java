package ru.borisov.springwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.borisov.springwebapp.entities.Product;
import ru.borisov.springwebapp.services.ProductService;

@Controller
public class MainController {

    private ProductService productService;


    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/shop")
    public String shopPage(Model model) {
        Product[] product = {
                new Product(1L, "Milk", 90),
                new Product(2L, "Coffee", 120),
                new Product(5L, "Jam", 60),

        };
        model.addAttribute("product", product[2]);
        return "shop";
    }

    @GetMapping("/details/{id}")
    public String detailsPage(Model model, @PathVariable("id") Long id) {
        Product selProduct = productService.getProducts().get(id.intValue()-1);
        model.addAttribute("selProduct", selProduct);
        return "details";
    }

}
