package com.studybuddy.controllers;
import javax.swing.*;
import java.util.Set;

import com.studybuddy.models.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.net.URL;
import java.util.ResourceBundle;

public class signUpController implements Initializable {
    @FXML
    public Button signUp_btn;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Login controller Initialized!");
        //opens new stage for dashboard when sign up successful
        signUp_btn.setOnAction(e -> {
          System.out.println("Sign Up Button pressed!");
          //TODO: pull email and password from text boxes and update if accordingly
//          if(){
//              Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//              Model.getInstance().getViewFactory().showDashboard(currentStage);
//          }
        });
    }
    private boolean isValidEmail(String email){
        // ensures the email address provided matches the characters within the brackets and their constraints
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return email.matches(regex);
    }

    private boolean isValidPassword(String password){
        int length = password.length();
        int uppers = 0, lowers = 0, numbers = 0, characters = 0; // ensures it has one of each
        Set<Character> specialChars = Set.of('!', '#', '@', '$', '%', '&', '*', '+', '?');
        String regex = "^[A-Za-z0-9!#@$%&*+?]{8,12}$"; // password can only be made of these characters and length 8-12
        if(password.matches(regex)){
            for(int i=0; i<length; i++){
                if (Character.isLowerCase(password.charAt(i))) {
                    lowers++;
                } else if (Character.isUpperCase(password.charAt(i))) {
                    uppers++;
                } else if (Character.isDigit(password.charAt(i))) {
                    numbers++;
                } else if (specialChars.contains(password.charAt(i))) {
                    characters++;
                }
            }
            if (lowers == 0 || uppers == 0 || numbers == 0 || characters == 0) {
                JOptionPane.showMessageDialog(null, "Password: Does not meet requirements");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password: Contains invalid characters");
            return false;
        }
        return true;
    }
}
