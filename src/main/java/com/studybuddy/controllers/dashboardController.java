package com.studybuddy.controllers;

import com.studybuddy.models.Model;
import com.studybuddy.models.Match;
import com.studybuddy.services.MatchIterator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.studybuddy.services.ApiClient.retreiveAllMatches;

public class dashboardController implements Initializable {
    private int startingIndex = 0; //index to track starting point for outputted matches
    private MatchIterator iterator;
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
        iterator = new MatchIterator(retreiveAllMatches());
        populateUserCards(iterator.getBatch(4));
        //startingIndex += 4;

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
            populateUserCards(iterator.getBatch(4));
        });
    }

    private void populateUserCards(List<Match> users) {
        AnchorPane[] userCards = {user1, user2, user3, user4};

        for (int i = 0; i < userCards.length; i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/userCard.fxml"));
                AnchorPane userCard = loader.load();
                userCardController controller = loader.getController();

                var match = users.get(i);
                if (match.getFirstName() == null)
                    controller.userName.setText("");
                else
                    controller.userName.setText(match.getFirstName());
                if (match.getMajor() == null)
                    controller.major.setText("");
                else
                    controller.major.setText(match.getMajor());
                if (match.getGradYear() == null)
                    controller.gradYear.setText("");
                else
                    controller.gradYear.setText(match.getGradYear().toString());

                if (match.getInterests() != null && !match.getInterests().isEmpty()) {
                    String[] interests = match.getInterests().toArray(new String[0]);
                    if (interests.length > 0) controller.interest1.setText(interests[0]);
                    if (interests.length > 1) controller.interest2.setText(interests[1]);
                    if (interests.length > 2) controller.interest3.setText(interests[2]);
                } else {
                    controller.interest1.setText("");
                    controller.interest2.setText("");
                    controller.interest3.setText("");
                }

                userCards[i].getChildren().setAll(userCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
