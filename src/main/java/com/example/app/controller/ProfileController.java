package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.ProfilePage;
import com.example.app.model.User;
import com.example.app.controller.UserSession;

public class ProfileController {
    UserSession userSession;
    User user = userSession.getLoggedInUser();
    //Takes the user to the Profile Page.
    public void goToProfilePage(){
        AppWindow.getAppWindow().openPage(ProfilePage.getProfilePage());
    }
    public String capitalizedName(){
        System.out.println("current user in Profile Controller" + user.getName());
        return user.getFName().substring(0, 1).toUpperCase() + user.getFName().substring(1);
    }
    //Return Bio if existing
    public String BioDisplay(){
        String bio = user.getBio();
        if(bio == null || bio.length() == 0){
            return "Talk about how awesome sauce you are here!";
        }
        return bio;
    }
    public String MajorDisplay(){
        String major = user.getMajor();
        return major;
    }
}