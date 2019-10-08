package ru.borisov.springwebapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.borisov.springwebapp.utils.ShoppingCart;

@Controller
//@RequestMapping("/cart")
public class CartController {

    private ShoppingCart cart;

    @Autowired
    public void setShoppingCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("products", cart.getProducts());
        System.out.println("Зашел");
        return "cart";
    }

    @GetMapping("cart/add/{id}")
    public String addProductToCart(@PathVariable("id") Long id) {
        System.out.println("Зашел2");
        cart.addProductById(id);
        return "redirect:/shop";
    }

}
