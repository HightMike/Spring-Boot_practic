package ru.borisov.springwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.borisov.springwebapp.entities.Product;
import ru.borisov.springwebapp.services.ProductService;

import java.util.List;

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
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("allProduct", allProducts);
        return "shop";
    }

    @GetMapping("/details/{id}")
    public String detailsPage(Model model, @PathVariable("id") Long id) {
        Product selProduct = productService.getProductById(id);
        model.addAttribute("selProduct", selProduct);
        return "details";
    }

    @GetMapping("/find_by_title")
    public String detailsPageByTitle(Model model, @RequestParam("title") String title) {
        Product selProduct = productService.getProductByTitle(title);
        model.addAttribute("selProduct", selProduct);
        return "details";
    }

}
