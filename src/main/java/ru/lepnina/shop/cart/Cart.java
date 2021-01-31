package ru.lepnina.shop.cart;

import ru.lepnina.shop.client.Client;
import ru.lepnina.shop.product.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "cart")
    private Set<Product> products;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    public Cart(Set<Product> products, Client client) {
        this.products = products;
        this.client = client;
    }

    public Cart(Long id, Set<Product> products, Client client) {
        this.id = id;
        this.products = products;
        this.client = client;
    }

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}