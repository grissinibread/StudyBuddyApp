package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.LoginPage;
import com.example.app.model.User;
//import com.example.app.controller.UserSession;

// mongoDB packages
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.example.app.util.MongoDBConnector;
import org.bson.Document;

import javax.swing.*;

public class LoginController {
    private final MongoDatabase database;
    public LoginController() {
        this.database = MongoDBConnector.getDatabase();
}
    protected UserSession userSession;
    //Takes the user to the Login Page.
    public void goToLoginPage(){
        AppWindow.getAppWindow().openPage(LoginPage.getLoginPage());
    }

    public static User getCurrentUser(String email, String password) { // pull user from database
        MongoDatabase database = MongoDBConnector.getDatabase();
        MongoCollection<Document> usersCollection = database.getCollection("SB_users");
        Document query = new Document("email", email).append("password", password);
        Document user = usersCollection.find(query).first();
        if (user != null) {
            // User found in the database
            System.out.println("User exists!");
            System.out.println("User details: " + user.toJson());
            return new User(user.getString("email"), user.getString("password"), user.getString("fname"),
                    user.getString("lname"), user.getInteger("age"), user.getString("major"),
                    user.getInteger("gradYear"));
        }
        return null;
    }

    private boolean verifyLogin (String email, String password){
        // TODO: ADD VALIDITY CHECK AGAINST DATABASE
        User currentUser = getCurrentUser(email, password);

        if (currentUser != null) {
            // User found in the database
            System.out.println("User exists!");
            userSession.setLoggedInUser(currentUser);
            return true;
        } else {
            // User does not exist
            System.out.println("User not found.");
            return false;
        }
    }

    public boolean attemptLogin(String email, String password){
        return verifyLogin(email, password);
    }
}