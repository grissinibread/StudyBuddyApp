package com.studybuddy.controllers;

import com.studybuddy.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @FXML
    public Button login_btn;

    @FXML
    public Button signUp_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Opens new stage for dashboard
        // TODO: Should close the login/signup window when dashboard opens
        login_btn.setOnAction(actionEvent -> Model.getInstance().getViewFactory().showDashboard());
        // TODO: Sign up should open up on the same stage
        signUp_btn.setOnAction(actionEvent -> Model.getInstance().getViewFactory().showSignUp());
    }
}