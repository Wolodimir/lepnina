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

    public void offCart(Long id){
        Cart cart = getCartById(id);
        Client client = cart.getClient();

        client.setActive(!cartRepo.findCartByClientIdAndActiveEquals(client.getId(),true).isEmpty());

        cart.setActive(false);

        cart.setClient(client);
        saveCart(cart);
    }

    public void saveCart(Cart cart){
        cartRepo.save(cart);
    }

    public String makeCart(String name, String phoneNumber, String email, String date, String[] cart){
        String cartString = "";
        for (int i = 0; i < cart.length; i++) {
            cartString += (cart[i] + ",");
        }
        if(clientService.findClientByNumber(phoneNumber).getPhoneNumber() == null){
            Client client = new Client(name, phoneNumber, email, true);
            clientService.saveClient(client);
            Cart cart1 = new Cart(client, cartString, date, true);
            cartRepo.save(cart1);
            return "Client exists";
        }
        Client client = clientService.findClientByNumber(phoneNumber);
        client.setActive(true);
        clientService.saveClient(client);
        Cart cart1 = new Cart(client, cartString, date, true);
        cartRepo.save(cart1);
        return "Saved";
    }

    public List<Cart> getActiveCarts(){
        return cartRepo.findByActiveEquals(true);
    }

    public List<Cart> getNotActiveCarts(){
        return cartRepo.findByActiveEquals(false);
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
        for (char c : chCart) {
            if (c == ',') {
                Product product = productService.getProduct(Long.parseLong(id)).orElse(new Product());
                productList.add(product);
                id = "";
                continue;
            }
            id += c;
        }
        return productList;
    }

    public void deleteCartById(Long id) {
        cartRepo.deleteById(id);
    }
}
