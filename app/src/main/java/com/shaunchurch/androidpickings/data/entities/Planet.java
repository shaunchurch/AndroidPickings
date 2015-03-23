package com.shaunchurch.androidpickings.data.entities;

public class Planet {

    private String name;
    private String type;

    public Planet(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
