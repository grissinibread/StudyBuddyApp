package com.studybuddy.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class viewFactory {
    private Stage primaryStage;

    public viewFactory(){};

    // shows the loginWindow
    public void showLogin(Stage stage) {
        this.primaryStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Scene loginScene = sceneCreator(loader);
        stageChange(loginScene);
        stage.show();
    }

    // shows the sign-up window
    public void showSignUp() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/signUp.fxml"));
        Scene signUpScene = sceneCreator(loader);
        stageChange(signUpScene);
    }

    // creates a new scene
    private Scene sceneCreator(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }

    // creates a new stage
    private Stage stageCreator(Scene scene) {
        Stage stage = new Stage();
        stage.setScene(scene);

        return stage;
    }

    // changes the scene on the stage
    private void stageChange(Scene scene) {
        this.primaryStage.setScene(scene);
    }
}