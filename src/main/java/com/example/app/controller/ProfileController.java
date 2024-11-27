package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.ProfilePage;

public class ProfileController {

    //Takes the user to the Profile Page.
    public void goToProfilePage(){
        AppWindow.getAppWindow().openPage(ProfilePage.getProfilePage());
    }
    private String capitalizeName(String name){
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}