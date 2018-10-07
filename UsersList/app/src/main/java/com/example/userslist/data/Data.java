package com.example.userslist.data;

import com.example.userslist.R;
import com.example.userslist.entity.User;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by ${Aina} on 05.10.2018.
 */
public class Data {
    public Collection<User> getUsers() {
        return Arrays.asList(new User("Aina", "Likes coffee, suicide jokes, tasty food and Marvel", R.drawable.pic2),
                new User("Liya", "Does IT homework at night", R.drawable.pic1),
                new User("Aliya", "Party girl from DD", R.drawable.pic2),
                new User("Kama", "Makes origami", R.drawable.pic1),
                new User("Lesya", "Loves her dog", R.drawable.pic2),
                new User("Elina", "Wants sushi", R.drawable.pic1),
                new User("Leyla", "Likes Marvel", R.drawable.pic2)
        );
    }
}
