package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.SettingsPage;

public class SettingsController {

    //Takes the user to the Settings Page.
    public void goToSettingsPage(){
        AppWindow.getAppWindow().openPage(SettingsPage.getSettingsPage());
    }
}