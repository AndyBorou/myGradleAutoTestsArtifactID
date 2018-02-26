package com.software.model;

import lombok.Data;

@Data
public class Dog {

    private final String name;


    public Dog() {
        this.name = "Bobik";
    }

    public Dog(String nameD) {
        this.name = nameD;
    }

}
