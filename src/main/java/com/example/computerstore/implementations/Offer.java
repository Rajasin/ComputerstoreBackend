package com.example.computerstore.implementations;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "business_seq")
    private Integer id;

    @Setter
    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @Column(nullable = false)
    private String name;

    @Column
    private String condition;

    @Column
    private String description;

    @Column
    private double price;

    protected Offer() { }

    public Offer(Business business, String name, double price, String description, String condition) {
        this.business = business;
        this.name = name;
        this.price = price;
        this.description = description;
        this.condition = condition;
    }

    public void showBusinessContact() {

    }

    public void showBusinessRating() {

    }

}
