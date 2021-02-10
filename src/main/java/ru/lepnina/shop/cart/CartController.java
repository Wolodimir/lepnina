package ru.lepnina.shop.cart;

import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PostMapping("/buy")
    public void saveCart(@RequestParam String name,
                         @RequestParam String phoneNumber,
                         @RequestParam String email,
                         @RequestParam String date,
                         @RequestParam String[] products
    ){
        cartService.makeCart(name, phoneNumber, email, date, products);
    }
}
