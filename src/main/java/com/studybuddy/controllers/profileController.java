package com.studybuddy.controllers;

import com.studybuddy.models.CurrentUser;
import com.studybuddy.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class profileController implements Initializable {

    @FXML
    public Button profile_dashboardButton;
    public Button profile_editProfButton;
    public Button profile_SaveButton;
    public Text profile_name;
    public Text profile_majorYr;
    public Text profile_email;
    public Text profile_age;
    public Text profile_bio;
    public Text profile_interests1;
    public Text profile_interests2;
    public Text profile_interests3;
    public Text profile_interests4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Profile page initialized!");

        // Retrieve the current user from the Model
        CurrentUser currentUser = Model.getInstance().getCurrentUser();

        // Populate the profile fields with the current user's data
        if (currentUser != null) {
            profile_name.setText(currentUser.getFirstName() + " " + currentUser.getLastName());
            profile_majorYr.setText(currentUser.getMajor() + " and class of " + currentUser.getGradYear());
            profile_email.setText(currentUser.getEmail());
            profile_age.setText("Age: " + currentUser.getAge());
            profile_bio.setText(currentUser.getBio());

            // interests
            if (currentUser.getInterests() != null && !currentUser.getInterests().isEmpty()) {
                String[] interests = currentUser.getInterests().toArray(new String[0]);
                if (interests.length > 0) profile_interests1.setText(interests[0]);
                if (interests.length > 1) profile_interests2.setText(interests[1]);
                if (interests.length > 2) profile_interests3.setText(interests[2]);

            } else {
                profile_interests1.setText("");
                profile_interests2.setText("");
                profile_interests3.setText("");

            }

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
}
