package com.example.toolbar;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ${Aina} on 12.10.2018.
 */
public class Data {
    public List<User> getUsers() {
        return Arrays.asList(new User("Aina", "Likes coffee, suicide jokes, tasty food and Marvel", 19),
                new User("Liya", "Does IT homework at night", 19),
                new User("Aliya", "Party girl from DD", 20),
                new User("Kama", "Makes origami", 43),
                new User("Lesya", "Loves her dog", 8),
                new User("Elina", "Wants sushi", 24),
                new User("Leyla", "Likes Marvel", 54)
        );
    }
}
