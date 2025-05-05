package com.studybuddy.controllers;

import com.studybuddy.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class profileController implements Initializable {

    @FXML
    public Button profile_dashboardButton;
    public Button profile_editProfButton;
    public Button profile_SaveButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Profile page initialized!");

        profile_dashboardButton.setOnAction(actionEvent -> {
            System.out.println("Dashboard button pressed!");
            Model.getInstance().getViewFactory().showDashboard();
        });
        profile_editProfButton.setOnAction(actionEvent -> {
            System.out.println("Edit Profile button pressed!");
            // TODO: Implement edit profile functionality
        });
        profile_SaveButton.setOnAction(actionEvent -> {
            System.out.println("Save button pressed!");
            // TODO: Implement save edited profile functionality
        });
    }
}
