package com.example.computerstore.implementations;

import com.example.computerstore.PasswordHashingUtil;
import com.example.computerstore.interfaces.Account;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User implements Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column
    private String location;

    @Column(name = "password", nullable = false)
    private String password;

    protected User() {}

    public User(String name, String surname, String location, String password) {
        this.name = name;
        this.surname = surname;
        this.location = location;
        this.setHashedPassword(password);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLocation() {
        return location;
    }

    public String getPassword() {
        return password;
    }

    public void showTransactions() {

    }

    public void editUserData() {

    }

    public void addToFavorites() {

    }

    public void setHashedPassword(String rawPassword) {
        this.password = PasswordHashingUtil.hashPassword(rawPassword);
    }

    public void showFavorites() {

    }

    public void rateBusiness(int rate) {

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
