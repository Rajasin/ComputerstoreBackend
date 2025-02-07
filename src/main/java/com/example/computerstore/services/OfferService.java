package com.example.computerstore.services;

import com.example.computerstore.implementations.Offer;
import com.example.computerstore.repositories.BusinessRepository;
import com.example.computerstore.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private BusinessRepository businessRepository;

    public Offer createOfferForBusiness(Integer businessId, String name, double price, String description, String condition) {
        // implementation omitted for shortness
        return null;
    }

    // Nowa metoda zwracająca wszystkie oferty
    public Iterable<Offer> findAllOffers() {
        return offerRepository.findAll();
    }
}