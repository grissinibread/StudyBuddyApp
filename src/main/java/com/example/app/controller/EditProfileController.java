package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.EditProfilePage;
import com.example.app.model.User;

public class EditProfileController {
    User user = UserSession.getLoggedInUser();

    //Takes the user to the EditProfile Page.
    public void goToEditProfilePage(){
        AppWindow.getAppWindow().openPage(EditProfilePage.geteditProfilePage());
    }
}
