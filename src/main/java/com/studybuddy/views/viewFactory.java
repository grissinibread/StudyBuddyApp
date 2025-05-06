package com.studybuddy.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class viewFactory {
    private Stage primaryStage;
    boolean loggedIn = false; // TODO: this is a placeholder, change later on if possible

    //TODO: idk if this could use a singleton too? we only really need one stage for most if not all content.
    public viewFactory(){
        if(!loggedIn) {
            primaryStage = new Stage();
            showLogin();
        }

        primaryStage.show();
    };

    // shows the login view
    public void showLogin() {
        loadScene("/fxml/login.fxml");
    }

    // shows the sign-up view
    public void showSignUp() {
        loadScene("/fxml/signUp.fxml");
    }

    // shows the profile view
    public void showProfile() {
        loadScene("/fxml/profile.fxml");
    }

    // shows the dashBoard view
    public void showDashboard() {
        loadScene("/fxml/dashBoard.fxml");
    }

    // shows connections page
    public void showConnections() {
        loadScene("/fxml/connections.fxml");
    }

    // shows edit profile page
    public void showEditProfile() { loadScene("/fxml/editProfile.fxml"); }

    // loads the fxml onto the Scene
    private void loadScene(String name) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(name));
        Scene loginScene = createScene(loader);
        changeScene(loginScene);
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
    private void changeScene(Scene scene) {
        this.primaryStage.setScene(scene);
    }
}