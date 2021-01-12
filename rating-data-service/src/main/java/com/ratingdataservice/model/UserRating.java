package com.ratingdataservice.model;

import java.util.List;

public class UserRating {

    private List<Rating> userList;

    public UserRating(List<Rating> userList) {
        this.userList = userList;
    }

    public UserRating() {
    }

    public List<Rating> getUserList() {
        return userList;
    }

    public void setUserList(List<Rating> userList) {
        this.userList = userList;
    }
}
