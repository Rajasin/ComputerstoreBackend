package com.example.computerstore.services;

import com.example.computerstore.implementations.Business;
import com.example.computerstore.implementations.Offer;
import com.example.computerstore.repositories.BusinessRepository;
import com.example.computerstore.repositories.OfferRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private BusinessRepository businessRepository;

    public Offer createOfferForBusiness(Integer businessId, String name, double price, String description, String condition) {

        Business business = businessRepository.findById(Long.valueOf(businessId))
                .orElseThrow(() -> new EntityNotFoundException("Business not found with id: " + businessId));

        Offer offer = new Offer(business, name, price, description, condition);

        return offerRepository.save(offer);
    }
}