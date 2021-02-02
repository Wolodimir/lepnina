package ru.lepnina.shop.cart;

import org.springframework.web.bind.annotation.*;
import ru.lepnina.shop.client.Client;
import ru.lepnina.shop.client.ClientService;
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
                         @RequestParam boolean active,
                         @RequestParam String[] a
    ){
        Client cli = new Client(name,phoneNumber,email,active);

        cartService.saveCart(cli,a);

        /*List<Product> productList = new ArrayList<>();
        Optional<Product> productOptional;

        char[] some = bigCart.toCharArray();
        String id = "";
        for (int i = 0; i < some.length; i++) {
            if (some[i] == ','){
                Product product = productService.getProduct(Long.parseLong(id)).orElse(new Product());
                productList.add(product);
                id = "";
                continue;
            }
            id += some[i];
        }*/

       /* Client client = new Client(name, phoneNumber, email, active);
        clientService.addNewClient(client);*/
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts(){
        return cartService.getCarts();
    }
}
