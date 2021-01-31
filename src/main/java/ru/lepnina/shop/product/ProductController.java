package ru.lepnina.shop.product;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.lepnina.shop.amazon.AmazonClient;

import java.io.IOException;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;
    private final AmazonClient amazonClient;
    public ProductController(ProductService productService, AmazonClient amazonClient) {
        this.productService = productService;
        this.amazonClient = amazonClient;
    }


    @PostMapping("/addProduct")
    public void uploadProduct(
            @RequestParam String description,
            @RequestParam String name,
            @RequestParam Long price,
            @RequestParam MultipartFile imageFile,
            @RequestParam String category
    ) throws IOException {
        productService.saveProduct(description, name, price, imageFile, category);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable(value = "id") Long id){
        productService.deleteProduct(id);
    }
}
