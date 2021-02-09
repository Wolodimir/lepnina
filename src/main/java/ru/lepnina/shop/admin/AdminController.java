package ru.lepnina.shop.admin;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.lepnina.shop.cart.Cart;
import ru.lepnina.shop.cart.CartService;
import ru.lepnina.shop.client.Client;
import ru.lepnina.shop.client.ClientService;
import ru.lepnina.shop.product.Product;
import ru.lepnina.shop.product.ProductService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class AdminController {

    private final ClientService clientService;
    private final ProductService productService;
    private final CartService cartService;

    public AdminController(ClientService clientService, ProductService productService, CartService cartService) {
        this.clientService = clientService;
        this.productService = productService;
        this.cartService = cartService;
    }

    /*
    * CLIENT WORKS SECTION
    */

    @GetMapping("/allClients")
    public List<Client> allClients(){
        return clientService.getClients();
    }

    @GetMapping("/activeClients")
    public List<Client> activeClients(){
        return clientService.getActiveClients();
    }

    @PostMapping("/activeClients/{id}")
    public void offClient(@PathVariable(value = "id") Long id){
        clientService.offClient(id);
    }

    /*
    * Product control section
    */

    @PostMapping("/addProduct")
    public void uploadProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String price,
            @RequestParam String height,
            @RequestParam String length,
            @RequestParam String width,
            @RequestParam String category,
            @RequestParam String subcategory,
            @RequestParam MultipartFile imageFile
    ) throws IOException {
        productService.saveProduct(name, description,
                Double.parseDouble(height),
                Double.parseDouble(length),
                Double.parseDouble(width),
                category,
                subcategory,
                Double.parseDouble(price),
                imageFile);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable(value = "id") Long id){
        productService.deleteProduct(id);
    }

    /*
    *Cart control section
    */

    @GetMapping("/activeCarts")
    public List<Cart> activeCarts(){
        return cartService.getActiveCarts();
    }

    @GetMapping("/offCarts")
    public List<Cart> offCarts(){
        return cartService.getNotActiveCarts();
    }

    @PostMapping("/offCart/{id}")
    public void offCart(@PathVariable(value = "id")Long id){
        cartService.offCart(id);
    }

    @GetMapping("/carts/{id}")
    public List<Product> getProductsInCart(@PathVariable(value = "id") Long id){
        return cartService.getProductInCart(cartService.getCartById(id).getCart());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOneCart(@PathVariable(value = "id") Long id){
        cartService.deleteCartById(id);
    }

}
