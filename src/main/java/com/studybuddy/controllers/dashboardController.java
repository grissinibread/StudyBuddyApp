package com.studybuddy.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {

     @FXML
    public Button dashboard_LogoutButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Dashboard controller initialized!");

        // Revert to Login page
        dashboard_LogoutButton.setOnAction(event -> {});
        System.out.println("Dashboard Log Out Button Clicked!");
    }
}