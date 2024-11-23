package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.ConnectionsPage;

public class ConnectionsController {

    //Takes the user to the Connections Page.
    public void goToConnectionsPage(){
        AppWindow.getAppWindow().openPage(ConnectionsPage.getConnectionsPage());
    }
}