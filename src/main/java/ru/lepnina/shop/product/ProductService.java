package ru.lepnina.shop.product;

import org.springframework.stereotype.Service;
import ru.lepnina.shop.amazon.AmazonClient;

@Service
public class ProductService {

    private final ProductRepo productRepo;
    private final AmazonClient amazonClient;

    public ProductService(ProductRepo productRepo, AmazonClient amazonClient) {
        this.productRepo = productRepo;
        this.amazonClient = amazonClient;
    }


}
