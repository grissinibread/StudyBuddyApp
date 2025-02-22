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
    public Button login_btn;

    @FXML
    public Button signUp_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Opens new stage for dashboard
        login_btn.setOnAction(actionEvent -> {
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Model.getInstance().getViewFactory().showDashboard(currentStage);
        });

        // Shows the sign-up page
        signUp_btn.setOnAction(actionEvent -> Model.getInstance().getViewFactory().showSignUp());
    }
}