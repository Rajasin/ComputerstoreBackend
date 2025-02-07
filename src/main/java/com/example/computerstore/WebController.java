package com.example.computerstore;

import com.example.computerstore.dtoObjects.BusinessDto;
import com.example.computerstore.dtoObjects.OfferDto;
import com.example.computerstore.dtoObjects.UserDto;
import com.example.computerstore.implementations.Business;
import com.example.computerstore.implementations.Offer;
import com.example.computerstore.implementations.User;
import com.example.computerstore.services.BusinessService;
import com.example.computerstore.services.OfferService;
import com.example.computerstore.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {
    private final UserService userService;
    private final BusinessService businessService;
    private final OfferService offerService;

    public WebController(UserService userService, BusinessService businessService, OfferService offerService) {
        this.userService = userService;
        this.businessService = businessService;
        this.offerService = offerService;
    }

    @GetMapping("/")
    public String index() {
        return "hello world";
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto.getName(), userDto.getSurname(), userDto.getLocation(), userDto.getPassword());
    }

    @PostMapping("/createBusiness")
    public Business createUser(@RequestBody BusinessDto businessDto) {
        return businessService.createBusiness(businessDto.getName(), businessDto.getNIP(), businessDto.getLocation(), businessDto.getPassword());
    }

    @PostMapping("/addOffer")
    public Offer addOffer(@RequestBody OfferDto offerDto) {
        return offerService.createOfferForBusiness(offerDto.getBusinessId(), offerDto.getName(), offerDto.getPrice(), offerDto.getDescription(), offerDto.getCondition());
    }

    // Nowy endpoint zwracający wszystkich użytkowników
    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userService.findAllUsers();
    }

    // Nowy endpoint zwracający wszystkie oferty
    @GetMapping("/offers")
    public Iterable<Offer> getAllOffers() {
        return offerService.findAllOffers();
    }
}