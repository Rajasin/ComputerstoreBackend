package com.example.computerstore.repositories;

import com.example.computerstore.implementations.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {}