package com.example.computerstore.dtoObjects;

import com.example.computerstore.implementations.Business;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfferDto {
    Integer business_id;
    String name;
    double price;
    String description;
    String condition;

    public Integer getBusinessId() {
        return business_id;
    }
}
