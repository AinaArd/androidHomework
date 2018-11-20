package com.example.toolbar;

/**
 * Created by ${Aina} on 12.10.2018.
 */
public class User {
    private int id;
    private String name;
    private String description;
    private int age;

    public User(String name, String description, int age) {
        this.name = name;
        this.description = description;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
