package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.MessagingPage;

public class MessagingController {

    //Takes the user to the Connections Page.
    public void goToConnectionsPage(){
        AppWindow.getAppWindow().openPage(MessagingPage.getConnectionsPage());
    }
}