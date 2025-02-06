package com.example.computerstore.implementations;

import com.example.computerstore.PasswordHashingUtil;
import com.example.computerstore.interfaces.Account;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "businesses")
public class Business implements Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "business_seq")
    private Integer id;

    @Column(nullable = false)
    private String name;
    @Column(name = "nip", nullable = false)
    private String NIP;
    @Column(nullable = false)
    private String location;
    @Column
    private double rating = 0;
    @Column(name = "password", nullable = false)
    private String password;

    protected Business() { }

    public Business(String name, String NIP, String location, String password) {
        this.name = name;
        this.NIP = NIP;
        this.location = location;
        setHashedPassword(password);
    }

    public void setHashedPassword(String rawPassword) {
        this.password = PasswordHashingUtil.hashPassword(rawPassword);
    }

    public void publishOffer() {

    }

    public void editOffer() {

    }

    public void deleteOffer() {

    }

    public void editBusinessData() {

    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public void changePassword() {

    }

    @Override
    public void sendMessage(String message) {

    }

    @Override
    public void showOffers() {

    }

}
