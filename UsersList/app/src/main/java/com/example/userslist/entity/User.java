package com.example.userslist.entity;

/**
 * Created by ${Aina} on 04.10.2018.
 */
public class User {
    private String name;
    private String context;

    public User(String name, String context) {
        this.name = name;
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }
}
