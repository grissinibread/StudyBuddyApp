package controller;

import view.SignupLoginPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
//import java.awt.event.*;


public class LoginController {
    // VALID EMAIL
    private boolean emailValid (String email){
        //System.out.println("email: " + email); // email check: reading correctly
        int length = email.length();
        int atIndex = email.indexOf("@"); // finds @ in email
        int dotIndex = email.indexOf("."); // finds . in email
        String end = email.substring(atIndex+1); // string after @
        //System.out.println("end: " + end);

        for (int i = 0; i < atIndex; i++) { // iterates through first half of email to ensure all characters are letters or numbers
            //System.out.println("checking " + email.charAt(i));
            if(!Character.isDigit(email.charAt(i)) && !Character.isLetter(email.charAt(i))){
                JOptionPane.showMessageDialog(null, "Email: Character Invalid");
                return false; // not valid if not
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
        return true;
    }

    // VALID PASSWORD
    private boolean passwordValid(String password){
        // RULES: 8-12 CHAR, AT LEAST 1 LOWERCASE, UPPERCASE, NUMBER, AND SPECIAL CHAR
        // SPECIAL CHAR: !, @, #, $, %, &, *, ?
        // ONLY THESE CHARACTERS
        //System.out.println("password: " + password);

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
        return true;
    }

    public boolean verifySignUp(String email, String password){
        return emailValid(email) && passwordValid(password);
    }

}