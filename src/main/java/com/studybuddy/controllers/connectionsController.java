package com.studybuddy.controllers;

import com.studybuddy.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class connectionsController implements Initializable {
    @FXML
    private Button connections_dashboardButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        connections_dashboardButton.setOnAction(event -> {
            Model.getInstance().getViewFactory().showDashboard();
        });
    }
}
