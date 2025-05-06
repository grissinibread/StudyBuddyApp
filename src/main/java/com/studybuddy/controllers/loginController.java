package com.studybuddy.controllers;

import com.studybuddy.models.Model;
import com.studybuddy.services.ApiClient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @FXML public Button login_loginButton;
    @FXML public Button login_signUpButton;

    @FXML private TextField emailTxt;
    @FXML private TextField passwordTxt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Login controller Initialized!");
        // Opens new stage for dashboard
        login_loginButton.setOnAction(actionEvent -> {
            System.out.println("Login button clicked!");
            String email = emailTxt.getText();
            String password = passwordTxt.getText();
            if (email.isEmpty() || password.isEmpty()) {
                System.out.println("Email or password cannot be empty.");
                return;
            }

            boolean loginSuccessful = ApiClient.logIn_User(email, password); // Call the API to log in the user
            System.out.println("Email: " + email + " Password: " + password);

            if (loginSuccessful) {

                System.out.println("Login successful! Redirecting to dashboard...");
                Model.getInstance().getViewFactory().showDashboard();
            } else {
                System.out.println("Login failed. Please check your credentials.");
            }
        });

        // Shows the sign-up page
        login_signUpButton.setOnAction(actionEvent -> {
            System.out.println("Sign-up button clicked!");
            Model.getInstance().getViewFactory().showSignUp();});
    }
}