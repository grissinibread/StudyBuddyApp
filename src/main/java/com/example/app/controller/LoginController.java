package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.LoginPage;

public class LoginController {

    //Takes the user to the Login Page.
    public void goToLoginPage(){
        AppWindow.getAppWindow().openPage(LoginPage.getLoginPage());
    }
}