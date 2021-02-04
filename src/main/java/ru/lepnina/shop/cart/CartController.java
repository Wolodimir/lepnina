package ru.lepnina.shop.cart;

import org.springframework.web.bind.annotation.*;
import ru.lepnina.shop.client.ClientService;
import ru.lepnina.shop.product.ProductService;


@RestController
@CrossOrigin
@RequestMapping("/api/cart")
public class CartController {

    private final ClientService clientService;
    private final ProductService productService;
    private final CartService cartService;

    public CartController(ClientService clientService, ProductService productService, CartService cartService) {
        this.clientService = clientService;
        this.productService = productService;
        this.cartService = cartService;
    }


    @PostMapping("/buy")
    public void saveCart(@RequestParam String name,
                         @RequestParam String phoneNumber,
                         @RequestParam String email,
                         @RequestParam String[] products
    ){
        cartService.makeCart(name, phoneNumber, email, products);
    }
}
