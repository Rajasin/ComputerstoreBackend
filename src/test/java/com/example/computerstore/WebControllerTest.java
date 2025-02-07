package com.example.computerstore;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.computerstore.implementations.Business;
import com.example.computerstore.implementations.Offer;
import com.example.computerstore.implementations.User;
import com.example.computerstore.services.BusinessService;
import com.example.computerstore.services.OfferService;
import com.example.computerstore.services.UserService;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
public class WebControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private OfferService offerService;

    @MockitoBean
    private BusinessService businessService;

    @MockitoBean
    private UserService userService;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello world")));
    }

    @Test
    public void getAllOffers() throws Exception {
        Business mockBusiness = new Business("mockName", "mockNIP", "mockLocation", "mockPassword"); //String name, String NIP, String location, String password

        Offer mockOffer1 = new Offer(mockBusiness, "Offer 1", 100.0, "Description 1", "New");
        Offer mockOffer2 = new Offer(mockBusiness, "Offer 2", 200.0, "Description 2", "Used");

        Mockito.when(offerService.findAllOffers()).thenReturn(Arrays.asList(mockOffer1, mockOffer2));
        mvc.perform(MockMvcRequestBuilders.get("/offers")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""
                [
                    {
                    "business": {
                      "name": "mockName",
                      "location": "mockLocation",
                      "rating": 0,
                      "nip": "mockNIP"
                    },
                    "name":"Offer 1",
                    "price":100.0,
                    "description":"Description 1",
                    "condition":"New"
                    },
                    {
                    "business": {
                    "name": "mockName",
                    "location": "mockLocation",
                    "rating": 0,
                    "nip": "mockNIP"
                    },
                    "name":"Offer 2",
                    "price":200.0,
                    "description":"Description 2",
                    "condition":"Used"
                    }
                ]
            """));
    }

    @Test
    public void getAllBusinesses() throws Exception {
        Business mockBusiness1 = new Business("mockName1", "mockNIP1", "mockLocation1", "mockPassword1");
        Business mockBusiness2 = new Business("mockName2", "mockNIP2", "mockLocation2", "mockPassword2");

        Mockito.when(businessService.findAllBusinesses()).thenReturn(Arrays.asList(mockBusiness1, mockBusiness2));
        mvc.perform(MockMvcRequestBuilders.get("/businesses")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""
                [
                    {"name":"mockName1", "nip":"mockNIP1", "location":"mockLocation1"},
                    {"name":"mockName2", "nip":"mockNIP2", "location":"mockLocation2"}
                ]
            """));
    }

    @Test
    public void getAllUsers() throws Exception {
        User mockUser1 = new User("mockName1", "mockSurname1", "mockLocation1", "mockPassword1");
        User mockUser2 = new User("mockName2", "mockSurname2", "mockLocation2", "mockPassword2");

        Mockito.when(userService.findAllUsers()).thenReturn(Arrays.asList(mockUser1, mockUser2));
        mvc.perform(MockMvcRequestBuilders.get("/users")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""
                [
                    {
                      "name": "mockName1",
                      "surname": "mockSurname1",
                      "location": "mockLocation1"
                    },
                    {
                      "name": "mockName2",
                      "surname": "mockSurname2",
                      "location": "mockLocation2"
                    }
                ]
            """));
    }
}