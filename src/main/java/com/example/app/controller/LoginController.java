package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.LoginPage;
import com.example.app.model.User;

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
    private User user = new User();

    //Takes the user to the Login Page.
    public void goToLoginPage(){
        AppWindow.getAppWindow().openPage(LoginPage.getLoginPage());
    }

    // TODO: THIS WILL CHANGE TO VERIFY AGAINST DATABASE
    private boolean emailValid (String email){
        // VERY IMPORTANT: email must be "hello" till todo is completed
        if (!email.equals("hello")){
            JOptionPane.showMessageDialog(null, "Temporary: make email \"hello\" and password \"world\"");
            System.out.println("Log In failed: Email must be \"hello\" for temporary test");
            return false;
        }
        // store in user if email is valid
        user.setEmail(email);
        return true;
    }

    // TODO: THIS WILL CHANGE TO VERIFY AGAINST DATABASE
    private boolean passwordValid(String password){
       // // VERY IMPORTANT: email must be "world" till todo is completed
        if (!password.equals("world")){
            System.out.println("Log In failed: Password must be \"world\" for temporary test");
            return false;
        }
        // store in user if password is valid
        user.setPassword(password);
        return true;
    }

    public boolean verifyLogin (String email, String password){
        // TODO: ADD VALIDITY CHECK AGAINST DATABASE
        MongoCollection<Document> usersCollection = database.getCollection("SB_users"); // grabs the entirety of the users database
        Document query = new Document("email", email).append("password", password);
        Document user = usersCollection.find(query).first();

        if (user != null) {
            // User found in the database
            System.out.println("User exists!");
            System.out.println("User details: " + user.toJson());

            // Optionally, check the password (hashed passwords recommended)
            if (password.equals(user.getString("password"))) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Incorrect password.");
            }
        } else {
            // User does not exist
            System.out.println("User not found.");
            return false;
        }

        //return emailValid(email) && passwordValid(password); // these will eventually be replaced with checking against database
        return true;
    }
}
// TODO: MAKE THIS MORE SECURE
// TODO: PASS CURRENT USER AND SAME FOR SIGN UP