package com.studybuddy.controllers;

import com.studybuddy.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;  // Ensure you're importing Label

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import static com.studybuddy.services.ApiClient.retreiveAllMatches;
import static com.studybuddy.services.ApiClient.retreiveAllUsers;

public class dashboardController implements Initializable {

    @FXML
    public Button dashboard_LogoutButton;

    @FXML
    public Button dashboard_profileButton;

    @FXML
    public Button refreshMatches;

    @FXML
    public Button dashboard_ConnectionsButton;

    // AnchorPane for user cards
    public AnchorPane user1;
    public AnchorPane user2;
    public AnchorPane user3;
    public AnchorPane user4;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Dashboard controller initialized!");

        populateUserCards();

        // Revert to Login page
        dashboard_LogoutButton.setOnAction(event -> {
            //TODO: Disconnect from database
            Model.getInstance().getViewFactory().showLogin();
        });

        dashboard_profileButton.setOnAction(actionEvent -> {
            System.out.println("profile button pressed");
            Model.getInstance().getViewFactory().showProfile();
        });

        dashboard_ConnectionsButton.setOnAction(actionEvent -> {
            System.out.println("connections button pressed");
            Model.getInstance().getViewFactory().showConnections();
        });

        refreshMatches.setOnAction(actionEvent -> {
            populateUserCards();
        });
    }

    private void populateUserCards() {
        var currentUser = Model.getInstance().getCurrentUser();
        System.out.println("Current user in discover: " + currentUser.getFirstName() + " " + currentUser.getId());
        var users = retreiveAllUsers();
        for (var user : users) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
        AnchorPane[] userCards = {user1, user2, user3, user4};

        for (int i = 0; i < users.size() && i < userCards.length; i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/userCard.fxml"));
                AnchorPane userCard = loader.load();
                userCardController controller = loader.getController();

                Random random = new Random();
                int randomIndex = random.nextInt(users.size());

                // Set user information using Labels
                controller.userName.setText(users.get(randomIndex).getFirstName() + " " + users.get(randomIndex).getLastName());
                controller.major.setText(users.get(randomIndex).getMajor());
                controller.gradYear.setText(users.get(randomIndex).getGradYear().toString());

                // Set interests using Labels
                if (users.get(randomIndex).getInterests() != null && !users.get(randomIndex).getInterests().isEmpty()) {
                    String[] interests = users.get(randomIndex).getInterests().toArray(new String[0]);
                    if (interests.length > 0) controller.interest1.setText(interests[0]);
                    if (interests.length > 1) controller.interest2.setText(interests[1]);
                    if (interests.length > 2) controller.interest3.setText(interests[2]);
                } else {
                    controller.interest1.setText("");
                    controller.interest2.setText("");
                    controller.interest3.setText("");
                }

                // Add the user card to the corresponding AnchorPane
                userCards[i].getChildren().setAll(userCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
