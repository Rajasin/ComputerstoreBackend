package com.example.computerstore.dtoObjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String name;
    private String surname;
    private String location;
    private String password;
}