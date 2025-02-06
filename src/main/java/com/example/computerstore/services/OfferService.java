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

    public Offer createOfferForBusiness(Integer businessId, Offer offer) {

        Business business = businessRepository.findById(Long.valueOf(businessId))
                .orElseThrow(() -> new EntityNotFoundException("Business not found"));

        offer.setBusiness(business);

        return offerRepository.save(offer);
    }
}