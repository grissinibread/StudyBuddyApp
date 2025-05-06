package com.studybuddy.controllers;

import com.studybuddy.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.studybuddy.services.ApiClient.retreiveAllUsers;

public class dashboardController implements Initializable {

     @FXML
    public Button dashboard_LogoutButton;

     @FXML
     public Button dashboard_profileButton;

     @FXML
    public Button dashboard_ConnectionsButton;
    public AnchorPane user1;
    public AnchorPane user2;
    public AnchorPane user3;
    public AnchorPane user4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Dashboard controller initialized!");

var users = retreiveAllUsers();
AnchorPane[] userCards = {user1, user2, user3, user4};

for (int i = 0; i < users.size() && i < userCards.length; i++) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/userCard.fxml"));
        AnchorPane userCard = loader.load();
        userCardController controller = loader.getController();

        // Set user information
        controller.setUserName(new Text(users.get(i).getFirstName() + " " + users.get(i).getLastName()));
//        controller.setUserCard_Major(users.get(i).getMajor());
//        controller.setUserCard_GraduationYear(users.get(i).getGradYear());
//        controller.setUserInterests(users.get(i).getInterests());


        // Add the user card to the corresponding AnchorPane
        userCards[i].getChildren().setAll(userCard);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

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
    }
}