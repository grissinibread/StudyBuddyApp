package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.SignUpPage;

import javax.swing.*;

public class SignUpController {
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
        //TODO: STORE IN USER
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
        //TODO: STORE IN USER
        return true;
    }

    // VALID NAME
    private boolean nameValid (String firstName, String lastName){
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
        //TODO: STORE IN USER
        return true;
    }

    //VALID AGE
    private boolean ageValid (int age){
        if (age < 16 || age > 100){
            JOptionPane.showMessageDialog(null, "Age Invalid");
            return false;
        }
        //TODO: STORE IN USER ?
        return true;
    }

    //TODO: MAJOR SELECT STORED IN USER
    //TODO: YEAR SELECT STORED IN USER

    // TODO: STORE USER IN DATABASE

    public boolean verifyLogin (String email, String password){
        // TODO: ADD VALIDITY CHECK AGAINST DATABASE
        return emailValid(email) && passwordValid(password); // these will eventually be replaced with checking against database
    }
    public boolean verifySignUp(String firstName, String lastName, String email, String password, String confirmPass, int age){
        if (!confirmPass.equals(password)) {
            JOptionPane.showMessageDialog(null, "Passwords Do Not Match");
            return false;
        }
        return verifyLogin(email, password) && nameValid(firstName, lastName) && ageValid(age);
    }

    //Takes the user to the SignUp Page.
    public void goToSignUpPage(){
        AppWindow.getAppWindow().openPage(SignUpPage.getSignUpPage());
    }
}