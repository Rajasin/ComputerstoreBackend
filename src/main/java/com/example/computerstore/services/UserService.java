package com.example.computerstore.services;

import com.example.computerstore.implementations.User;
import com.example.computerstore.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String surname, String location, String password) {
        User user = new User(name, surname, location, password);
        return userRepository.save(user);
    }

    // Nowa metoda zwracająca listę wszystkich użytkowników bez hasła
    public Iterable<User> findAllUsers() {
        Iterable<User> users = userRepository.findAll();
        users.forEach(user -> user.setHashedPassword(null));
        return users;
    }
}