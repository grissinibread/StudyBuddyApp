package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.InboxPage;

public class InboxController {
    //Takes the user to the Inbox Page.
    public void goToInboxPage(){
        AppWindow.getAppWindow().openPage(InboxPage.getInboxPage());
    }
}
