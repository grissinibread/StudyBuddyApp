package com.studybuddy.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class viewFactory {
    private AnchorPane dashboardView;

    public viewFactory(){};

    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        createStage(loader);
    }

    public void showDashboard() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dashBoard.fxml"));
        createStage(loader);
    }

    public void showSignUp() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/signUp.fxml"));
        createStage(loader);
    }

    public void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Study Buddy");
        stage.centerOnScreen();
        stage.show();
    }
}