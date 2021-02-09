package ru.lepnina.shop.product;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(columnDefinition = "text")
    private String description;

    private Double height;
    private Double length;
    private Double width;

    private String category;
    private String subcategory;

    private Double price;

    private String imageUrl;

    public Product(String name,
                   String description,
                   Double height,
                   Double length,
                   Double width,
                   String category,
                   String subcategory,
                   Double price,
                   String imageUrl) {
        this.name = name;
        this.description = description;
        this.height = height;
        this.length = length;
        this.width = width;
        this.category = category;
        this.subcategory = subcategory;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Product(Long id,
                   String name,
                   String description,
                   Double height,
                   Double length,
                   Double width,
                   String category,
                   String subcategory,
                   Double price,
                   String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.height = height;
        this.length = length;
        this.width = width;
        this.category = category;
        this.subcategory = subcategory;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
