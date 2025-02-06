package com.example.computerstore.services;

import com.example.computerstore.implementations.Business;
import com.example.computerstore.implementations.User;
import com.example.computerstore.repositories.BusinessRepository;
import com.example.computerstore.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;

    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public Business createBusiness(String name, String NIP, String location, String password) {
        Business business = new Business(name, NIP, location, password);
        return businessRepository.save(business);
    }

    //todo zrobić takie metody dla pozostałych dwóch klas. Gdy Wywołuję tę funkcję endpointem, to chcę dostać w informacji zwrotnej listę obiektów
    public Iterable<Business> findAllBusinesses() {
        return businessRepository.findAll();
    }

}