package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.EditProfilePage;
import com.example.app.model.User;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.example.app.util.MongoDBConnector;
import org.bson.Document;
import javax.swing.JOptionPane;

public class EditProfileController {
    protected User user = UserSession.getLoggedInUser();

    //Takes the user to the EditProfile Page.
    public void goToEditProfilePage(){
        AppWindow.getAppWindow().openPage(EditProfilePage.getEditProfilePage());
    }
    private final SignUpController signUpController = new SignUpController();

    public boolean validateAndUpdateProfile(String firstName, String lastName, String email, Integer year, String major, String bio, String interest1, String interest2, String interest3) {
        // Use validation methods from SignUpController
        if (!signUpController.nameValid(firstName, lastName)) {
            JOptionPane.showMessageDialog(null, "Invalid first name or last name");
            return false;
        }
        if (bio.length() > 400) {
            JOptionPane.showMessageDialog(null, "Description must be less than 400 characters");
            return false;
        }
//        if (interest1.equals(interest2) || interest1.equals(interest3) || interest2.equals(interest3)) {
//            JOptionPane.showMessageDialog(null, "Interests must be different");
//            return false;
//        }
        if (interest1.equals("Select interest") || interest2.equals("Select interest") || interest3.equals("Select interest")) {
            JOptionPane.showMessageDialog(null, "Please select 3 interests");
            return false;
        }

        // Update user information
        user.setName(firstName, lastName);
        user.setFName(firstName);
        user.setLName(lastName);
        user.setYear(year);
        user.setMajor(major);
        user.setInterests(interest1,interest2,interest3);

        // Save updated user info to the database
        updateUserInDatabase();
        return true;
    }

    private void updateUserInDatabase() {
        try {
            MongoDatabase database = MongoDBConnector.getDatabase();
            MongoCollection<Document> usersCollection = database.getCollection("StudyBuddy2.0");
            Document query = new Document("email", user.getEmail());

            // update document with all updated fields
            Document update = new Document("$set", new Document()
                    .append("name", user.getName())
                    .append("fname", user.getFName())
                    .append("lname", user.getLName())
                    .append("password", user.getPassword())
                    .append("age", user.getAge())
                    .append("major", user.getMajor())
                    .append("year", user.getYear())
                    .append("interests", user.getInterests())
                    .append("bio", user.getBio()));

            // update
            usersCollection.updateOne(query, update);
            System.out.println("User profile successfully updated.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating user in database: " + e.getMessage());
        }
    }
}
