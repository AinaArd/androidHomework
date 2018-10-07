package com.example.userslist.entity;

import android.media.Image;

/**
 * Created by ${Aina} on 04.10.2018.
 */
public class User {
    private String name;
    private String description;
    private int userPic;

    public User(String name, String description, int userPic) {
        this.name = name;
        this.description = description;
        this.userPic = userPic;
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

    public int getUserPic() {
        return userPic;
    }

    public void setUserPic(int userPic) {
        this.userPic = userPic;
    }
}
