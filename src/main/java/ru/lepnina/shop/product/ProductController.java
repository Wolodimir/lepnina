package ru.lepnina.shop.product;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/allProducts")
    public List<Product> getAllProducts(){
        return productService.getProducts();
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
