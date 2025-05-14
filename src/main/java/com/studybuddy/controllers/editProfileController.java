package com.studybuddy.controllers;

import javafx.scene.control.Button;

import com.studybuddy.models.Model;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class editProfileController {
    @FXML
    public Button editProf_saveButton;
    public Button editProf_cancelButton;

    public void initialize() {
        editProf_saveButton.setOnAction(actionEvent -> {
            System.out.println("Save button pressed!");
            // TODO: Implement save edited profile functionality
        });
        editProf_cancelButton.setOnAction(actionEvent -> {
            System.out.println("Cancel button pressed!");
            Model.getInstance().getViewFactory().showProfile();
        });

//    editProf_saveButton.setOnAction(actionEvent -> {
//        System.out.println("Save button clicked!");


    }

}
