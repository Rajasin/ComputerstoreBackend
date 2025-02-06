package com.example.computerstore.dtoObjects;

import com.example.computerstore.implementations.Business;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfferDto {
    Business business;
    String name;
    double price;
    String description;
    String condition;
}
