package com.studybuddy.controllers;

import com.studybuddy.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @FXML
    public Button login_loginButton;

    @FXML
    public Button login_signUpButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Login controller Initialized!");
        // Opens new stage for dashboard
        login_loginButton.setOnAction(actionEvent -> {
            System.out.println("Login button clicked!");
            Model.getInstance().getViewFactory().showDashboard((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
        });

        // Shows the sign-up page
        login_signUpButton.setOnAction(actionEvent -> {
            System.out.println("Sign-up button clicked!");
            Model.getInstance().getViewFactory().showSignUp();});
    }
}