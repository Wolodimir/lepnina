package ru.lepnina.shop.product;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.lepnina.shop.amazon.AmazonClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepo;
    private final AmazonClient amazonClient;

    public ProductService(ProductRepo productRepo, AmazonClient amazonClient) {
        this.productRepo = productRepo;
        this.amazonClient = amazonClient;
    }


    public void saveProduct(String name,
                            String description,
                            Double height,
                            Double length,
                            Double width,
                            String category,
                            String subcategory,
                            Double price,
                            MultipartFile imageFile
                            ) throws IOException {
        Product p = new Product();
        p.setHeight(height);
        p.setLength(length);
        p.setWidth(width);
        p.setSubcategory(subcategory);
        p.setPrice(price);
        p.setName(name);
        p.setCategory(category);
        p.setDescription(description);
        p.setImageUrl(amazonClient.uploadFile(imageFile));
        productRepo.save(p);
    }
    public Optional<Product> getProduct(Long id){
        return productRepo.findById(id);
    }


    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public void deleteProduct(Long id){
        boolean exists = productRepo.existsById(id);
        if(!exists){
            throw new IllegalStateException("Product with id " + id + " does not exists");
        }
        Optional<Product> product = productRepo.findById(id);
        ArrayList<Product> p = new ArrayList<>();
        product.ifPresent(p::add);
        Product product1 = p.get(p.size()-1);

        amazonClient.deleteFileFromS3Bucket(product1.getImageUrl());

        productRepo.deleteById(id);
    }
}
