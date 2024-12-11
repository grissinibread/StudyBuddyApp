package com.example.app.controller;

import com.example.app.model.User;


public class UserSession {
    // allow user to be passed from both log in and sign up
    private static User loggedInUser;
    public static void setLoggedInUser(User user) {loggedInUser = user;}
    public static User getLoggedInUser() {return loggedInUser;}
}
