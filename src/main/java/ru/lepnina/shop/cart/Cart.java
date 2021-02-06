package ru.lepnina.shop.cart;

import org.hibernate.annotations.Cascade;
import ru.lepnina.shop.client.Client;
import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    private String cart;

    private Boolean active;

    public Cart(Client client, String cart, Boolean active) {
        this.client = client;
        this.cart = cart;
        this.active = active;
    }

    public Cart(Long id, Client client, String cart, Boolean active) {
        this.id = id;
        this.client = client;
        this.cart = cart;
        this.active = active;
    }

    public Cart() {
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
