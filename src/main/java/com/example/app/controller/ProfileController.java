//package com.example.app.controller;
//
//import com.example.app.view.AppWindow;
//import com.example.app.view.ProfilePage;
//import com.example.app.model.User;
//import com.example.app.controller.UserSession;
//
//import java.util.List;
//
//public class ProfileController {
//    User user = UserSession.getLoggedInUser();
//    //Takes the user to the Profile Page.
//    public void goToProfilePage(){
//        AppWindow.getAppWindow().openPage(ProfilePage.getProfilePage());
//    }
//
//    public String capitalizedName(){
//        System.out.println("current user in Profile Controller: " + user.getName());
//        return user.getFName().substring(0, 1).toUpperCase() + user.getFName().substring(1);
//    }
//    //Return Bio if existing
//    public String displayBio(){
//        String bio = user.getBio();
//        if(bio == null || bio.length() == 0){
//            bio = "Talk about how awesome you are here!";
//            user.setBio(bio);
//        }
//        return bio;
//    }
//    public String displayMajor(){
//        String major = user.getMajor();
//        return major;
//    }
//    public Integer displayGradYear(){
//        Integer gradYear = user.getYear();
//        return gradYear;
//    }
//
//    public String displayInterests(){
//        String[]interests = user.getInterests();
////        if(interests == null || interests.isEmpty()){
////            return "Pick some interests to display here! :)";
////        }
//        return String.join(", ", interests);
//    }
//}