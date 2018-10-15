package com.example.toolbar;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ${Aina} on 12.10.2018.
 */
public class Data {
    public List<User> getUsers() {
        return Arrays.asList(new User(1, "Aina", "Likes coffee, suicide jokes, tasty food and Marvel", 19),
                new User(2, "Liya", "Does IT homework at night", 19),
                new User(3, "Aliya", "Party girl from DD", 20),
                new User(4,"Kama", "Makes origami", 43),
                new User(5, "Lesya", "Loves her dog", 8),
                new User(6, "Elina", "Wants sushi", 24),
                new User(7, "Leyla", "Likes Marvel", 54)
        );
    }
}
