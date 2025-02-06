package com.example.computerstore.repositories;

import com.example.computerstore.implementations.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {}