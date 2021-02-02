package ru.lepnina.shop.admin;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    public AdminController(ClientService clientService, ProductService productService) {
        this.clientService = clientService;
        this.productService = productService;
    }

    /*
    * CLIENT WORKS SECTION
    * */

    @GetMapping("/allClients")
    public List<Client> allClients(){
        return clientService.getClients();
    }

    @PostMapping("/addNewClient")
    public void addNewClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }

    @GetMapping("/activeClients")
    public List<Client> activeClients(){
        return clientService.getActiveClients();
    }

    /*
    * Product control section
    * */

    @PostMapping("/addProduct")
    public void uploadProduct(
            @RequestParam String description,
            @RequestParam String name,
            @RequestParam String price,
            @RequestParam MultipartFile imageFile,
            @RequestParam String category
    ) throws IOException {
        productService.saveProduct(description, name, Long.parseLong(price), imageFile, category);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable(value = "id") Long id){
        productService.deleteProduct(id);
    }

    /*
    *
    * */

}
