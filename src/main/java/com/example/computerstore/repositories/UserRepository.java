package com.example.computerstore.repositories;

import com.example.computerstore.implementations.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}