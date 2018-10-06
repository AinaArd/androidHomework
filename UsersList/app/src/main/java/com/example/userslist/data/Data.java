package com.example.userslist.data;

import com.example.userslist.entity.User;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by ${Aina} on 05.10.2018.
 */
public class Data {
    public Collection<User> getUsers() {
        return Arrays.asList(new User("Aina", "Likes coffee, suicide jokes, tasty food and Marvel"),
                new User("Liya", "Does IT homework at night"),
                new User("Aliya", "Party girl from DD"),
                new User("Kama", "Makes origami"),
                new User("Lesya", "Loves her dog"),
                new User("Elina", "Wants sushi"),
                new User("Leyla", "Likes Marvel")
        );
    }
}
