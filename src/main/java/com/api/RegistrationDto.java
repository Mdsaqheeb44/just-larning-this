package com.api;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

public class RegistrationDto {


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "mobile", nullable = false, unique = true)
    private String mobile;

}