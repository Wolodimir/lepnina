package ru.lepnina.shop.client;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;
    private Boolean active;
    private String date;


    public Client(String name, String phoneNumber, String email, String date) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.date = date;
    }

    public Client(String name, String phoneNumber, String email, Boolean active, String date) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.active = active;
        this.date = date;
    }

    public Client(Long id, String name, String phoneNumber, String email, Boolean active, String date) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.active = active;
        this.date = date;
    }

    public Client() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String telephone) {
        this.phoneNumber = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
