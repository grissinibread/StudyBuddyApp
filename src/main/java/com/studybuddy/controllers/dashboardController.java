package com.studybuddy.controllers;

import com.studybuddy.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {

     @FXML
    public Button dashboard_LogoutButton;

     @FXML
     public Button dashboard_profileButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Dashboard controller initialized!");

        // Revert to Login page
        dashboard_LogoutButton.setOnAction(event -> {
            //TODO: Disconnect from database
            Model.getInstance().getViewFactory().showLogin();
        });

        dashboard_profileButton.setOnAction(actionEvent -> {
            System.out.println("profile button pressed");
            Model.getInstance().getViewFactory().showProfile();
        });
    }
}