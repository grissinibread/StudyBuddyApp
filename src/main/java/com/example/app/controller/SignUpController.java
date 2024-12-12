package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.SignUpPage;
import com.example.app.model.User;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.example.app.util.MongoDBConnector;

import org.bson.Document;

import javax.swing.*;

public class SignUpController {
    protected User user = UserSession.getLoggedInUser();
    // VALID EMAIL
    private boolean emailValid (String email){
        int length = email.length();
        int atIndex = email.indexOf("@"); // finds @ in email
        int dotIndex = email.indexOf("."); // finds . in email
        String end = email.substring(atIndex+1); // string after @

        for (int i = 0; i < atIndex; i++) { // iterates through first half of email to ensure all characters are letters or numbers
            if(!Character.isDigit(email.charAt(i)) && !Character.isLetter(email.charAt(i))){
                JOptionPane.showMessageDialog(null, "Email: Character Invalid");
                return false;
            }
        }
        if (atIndex == -1 || dotIndex == -1){ // missing "@" or "." means not valid
            JOptionPane.showMessageDialog(null, "Email: Format Invalid");
            return false;
        }
        if (!end.equals("csusm.edu")){ // not csusm email means not valid
            JOptionPane.showMessageDialog(null, "Email: Not CSUSM Email");
            return false;
        }
        // store in user if email is valid
        user.setEmail(email);
        return true;
    }

    // VALID PASSWORD
    private boolean passwordValid(String password){
        // RULES: 8-12 CHAR, AT LEAST 1 LOWERCASE, UPPERCASE, NUMBER, AND SPECIAL CHAR
        // SPECIAL CHAR: !, @, #, $, %, &, *, ?
        // ONLY THESE CHARACTERS

        // BETWEEN 8-12 CHAR
        int length = password.length();
        if (length < 8 || length > 12){
            JOptionPane.showMessageDialog(null, "Password: Length Invalid");
            return false;
        }

        int lowecaseCount = 0;
        int uppercaseCount = 0;
        int specialCharCount = 0;
        int numCount = 0;

        for (int i = 0; i < length; i++){
            if (Character.isLetter(password.charAt(i))){ // checks if letter
                // ACCOUNTS FOR LOWERCASE
                if(password.charAt(i) > 96 && password.charAt(i) < 123){ lowecaseCount++;}
                // ACCOUNTS FOR UPPERCASE
                else if (password.charAt(i) >= 65 && password.charAt(i) < 90) { uppercaseCount++;}
            }
            // ACCOUNTS FOR NUMBER
            else if (Character.isDigit(password.charAt(i))){
                numCount++;
            }
            // ACCOUNTS FOR SPECIAL CHAR
            else if (password.charAt(i)=='!' || password.charAt(i)=='#' || password.charAt(i)=='@' || password.charAt(i)=='$' || password.charAt(i)=='%' || password.charAt(i)=='&' || password.charAt(i)=='*' || password.charAt(i)=='+' || password.charAt(i)=='?'){
                specialCharCount++;
            }
            // CHAR INVALID
            else {
                JOptionPane.showMessageDialog(null, "Password: Character Invalid");
                return false;
            }
        }
        if (lowecaseCount == 0 || uppercaseCount == 0 || specialCharCount == 0 || numCount == 0){
            JOptionPane.showMessageDialog(null, "Password: Character Missing");
            return false;
        }
        // store in user if password is valid
        user.setPassword(password);
        return true;
    }

    // VALID NAME
    public boolean nameValid (String firstName, String lastName){
        // VALID FORMATS: Name Last, Name Name Last, Name Name Last-Last, Name Name Last Last, etc.
        int firstlength = firstName.length();
        int lastlength = lastName.length();
        // first name verification
        for (int i = 0; i < firstlength; i++){
            if (!Character.isLetter(firstName.charAt(i))){ // verifies characters
                // allows hyphenated names and spaces
                if(firstName.charAt(i) != '-' && firstName.charAt(i) != ' '){
                    JOptionPane.showMessageDialog(null, "First Name(s): Character Invalid");
                    return false;
                }
            }
        }
        // last name verification
        for (int j = 0; j < lastlength; j++){
            if (!Character.isLetter(lastName.charAt(j))){ // verifies characters
                // allows hyphenated names and spaces
                if(lastName.charAt(j) != '-' && lastName.charAt(j) != ' '){
                    JOptionPane.showMessageDialog(null, "Last Name(s): Character Invalid");
                    return false;
                }
            }
        }
        // store in user if name is valid (Full name & separated first name, last name)
        user.setName(firstName, lastName); user.setFName(firstName); user.setLName(lastName);
        return true;
    }

    //VALID AGE
    public boolean ageValid (Integer age){
        if (age < 16 || age > 100){
            JOptionPane.showMessageDialog(null, "Age Invalid");
            return false;
        }
        // store in user if name is valid
        user.setAge(age);
        return true;
    }

    // Store user in MongoDB upon Sign Up
    public void storeUser() {
        try {
            MongoDatabase database = MongoDBConnector.getDatabase();
            MongoCollection<Document> usersCollection = database.getCollection("StudyBuddy2.0");

            Document userDocument = new Document()
                    .append("name", user.getName())             // Full name
                    .append("fname", user.getFName())           // First name
                    .append("lname", user.getLName())           // Last name
                    .append("email", user.getEmail())           // Email
                    .append("password", user.getPassword())     // Password
                    .append("age", user.getAge())               // Age
                    .append("major", user.getMajor())           // Major
                    .append("gradYear", user.getYear())         // Year
                    .append("bio", user.getBio())               // Bio
                    .append("interest1", user.getInterest1())
                    .append("interest2", user.getInterest2())
                    .append("interest3", user.getInterest3()); // Interests List


            usersCollection.insertOne(userDocument);
            System.out.println("User successfully added to the database. :) "+ userDocument);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error storing user in database: " + e.getMessage());
        }
    }

    // Check for existing email in DB
    public boolean verifyEmail_DB(String email){
        MongoDatabase database = MongoDBConnector.getDatabase();
        MongoCollection<Document> usersCollection = database.getCollection("StudyBuddy2.0");
        Document query = new Document("email", email);
        Document user = usersCollection.find(query).first();
        return user != null; // Return true if email exists
    }

    // Check for matching password in DB
    public boolean verifyPassword_DB(String email, String password){
        MongoDatabase database = MongoDBConnector.getDatabase();
        MongoCollection<Document> usersCollection = database.getCollection("StudyBuddy2.0");
        Document query = new Document("email", email).append("password", password);
        Document user = usersCollection.find(query).first();
        return user != null; // Return true if email and password match
    }

    //note: there are two verifyLogin functions(SignUp & Login Controller)
    //Check if email and password are correct/match database
    public boolean verifyLogin (String email, String password){
        try {
            // If email is existing email in DB
            if (verifyEmail_DB(email)) {
                JOptionPane.showMessageDialog(null, "This email address is already taken. Please try another.");
                return false;
            }

            // If email is incorrect/does not match database
            if(!verifyPassword_DB(email, password)) {
                JOptionPane.showMessageDialog(null,"Incorrect password.");
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Verifying Login: " + e.getMessage());
            return false;
        }
        //return emailValid(email) && passwordValid(password); // these will eventually be replaced with checking against database
    }
    public boolean verifySignUp(String firstName, String lastName, String email, String password, String confirmPass, Integer age, String major, Integer gradYear){
        if (!confirmPass.equals(password)) {
            JOptionPane.showMessageDialog(null, "Passwords Do Not Match");
            return false;
        }

        // Store user info after validation and non-existing email
        if(emailValid(email) && passwordValid(password) && nameValid(firstName, lastName) && ageValid(age) && !verifyEmail_DB(email)){
            user.setMajor(major);
            user.setYear(gradYear);
            UserSession.setLoggedInUser(user);
            System.out.println("user about to be stored: " + user + " " + user.getName() + " " + user.getEmail() + " " + user.getPassword() + " " + user.getAge() + " " + user.getMajor() + " " + user.getYear());
            System.out.println("User instance in SignUpController: " + user);
            storeUser();
            return true;
        } else if (verifyEmail_DB(email)) {
            JOptionPane.showMessageDialog(null, "This email address is already taken. Please try another.");
        }
        return false;
    }

    //Takes the user to the SignUp Page.
    public void goToSignUpPage(){
        AppWindow.getAppWindow().openPage(SignUpPage.getSignUpPage());
    }
}