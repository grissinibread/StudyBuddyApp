package com.studybuddy.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class viewFactory {
    private Stage primaryStage;

    public viewFactory(){};

    // TODO: Fix structure

    // shows the login view
    public void showLogin(Stage stage) {
        this.primaryStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Scene loginScene = createScene(loader);
        changeStage(loginScene);
        stage.show();
    }

    // shows the sign-up view
    public void showSignUp() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/signUp.fxml"));
        Scene signUpScene = createScene(loader);
        changeStage(signUpScene);
    }

    // shows the dashBoard view
    public void showDashboard(Stage currentStage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dashBoard.fxml"));
        Scene dashBoardScene = createScene(loader);
        createNewStage(dashBoardScene).show();
        currentStage.close();
    }

    // creates a new scene
    private Scene createScene(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }

    // creates a new stage
    private Stage createNewStage(Scene scene) {
        Stage stage = new Stage();
        stage.setScene(scene);

        return stage;
    }

    // changes the scene on the stage
    private void changeStage(Scene scene) {
        this.primaryStage.setScene(scene);
    }
}