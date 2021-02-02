package ru.lepnina.shop.cart;

import org.springframework.stereotype.Service;
import ru.lepnina.shop.client.Client;
import ru.lepnina.shop.client.ClientService;
import ru.lepnina.shop.product.Product;
import ru.lepnina.shop.product.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepo cartRepo;
    private final ProductService productService;
    private final ClientService clientService;

    public CartService(CartRepo cartRepo, ProductService productService, ClientService clientService) {
        this.cartRepo = cartRepo;
        this.productService = productService;
        this.clientService = clientService;
    }


    public void saveCart(Client client, String[] cart){
        String a = "";
        for (int i = 0; i < cart.length; i++) {
            a += (cart[i] + ",");
        }

        Cart cart1 = new Cart(client, a, true);
        clientService.addNewClient(client);
        cartRepo.save(cart1);
    }

    public Cart getCartById(Long cart_id){
        return cartRepo.findById(cart_id).orElse(new Cart());
    }
    public List<Cart> getCarts(){
        return cartRepo.findAll();
    }

    public List<Product> getProductInCart(String cart){
        List<Product> productList = new ArrayList<>();
        Optional<Product> productOptional;
        char[] chCart = cart.toCharArray();
        String id = "";
        for (int i = 0; i < chCart.length; i++) {
            if(chCart[i] == ','){
                Product product = productService.getProduct(Long.parseLong(id)).orElse(new Product());
                productList.add(product);
                id = "";
                continue;
            }
            id +=chCart[i];
        }
        return productList;
    }

    public void deleteCartById(Long id) {
        cartRepo.deleteById(id);
    }
}
