package ru.lepnina.shop.cart;

import org.springframework.web.bind.annotation.*;
import ru.lepnina.shop.client.Client;
import ru.lepnina.shop.client.ClientService;
import ru.lepnina.shop.product.Product;
import ru.lepnina.shop.product.ProductService;

import java.util.List;

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

        Client cli = new Client(name,phoneNumber,email,true);

        cartService.makeCart(cli,products);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteOneCart(@PathVariable(value = "id") Long id){
        cartService.deleteCartById(id);
    }
}
