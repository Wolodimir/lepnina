package ru.lepnina.shop.cart;

import ru.lepnina.shop.client.Client;
import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    private String cart;

    public Cart(Client client, String cart) {
        this.client = client;
        this.cart = cart;
    }

    public Cart(Long id, Client client, String cart) {
        this.id = id;
        this.client = client;
        this.cart = cart;
    }

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }
}
