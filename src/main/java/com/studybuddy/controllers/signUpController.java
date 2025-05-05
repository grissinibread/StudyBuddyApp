package com.studybuddy.controllers;
import javax.swing.*;
import java.util.Set;

import com.studybuddy.models.Model;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.control.TextField; // to pull text from boxes

import java.net.URL;
import java.util.ResourceBundle;

public class signUpController implements Initializable {
    @FXML
    public Button signUp_signUpButton;
    @FXML
    public Button signUp_LoginButton;

    @FXML private TextField fullNameTxt;
    @FXML private TextField emailTxt;
    @FXML private TextField passwordTxt;
    @FXML private TextField repeatPasswordTxt;

    private String fullName; // holds full name from text box
    private String email; // holds email from text box
    private String password; // holds pass
    private String repeatPassword; // holds pass

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Sign Up controller Initialized!");
        //opens new stage for dashboard when sign up successful
         signUp_signUpButton.setOnAction(actionEvent -> {
           System.out.println("Sign Up Button pressed!");

           fullName = fullNameTxt.getText();
           email = emailTxt.getText();
           password = passwordTxt.getText();
           repeatPassword = repeatPasswordTxt.getText();
          if(isValidEmail(email) && isValidPassword(password) && repeatPassword.equals(password)) { //all valid open dashboard
              Model.getInstance().getViewFactory().showDashboard();
              // TODO: STORE IN DATABASE
          }
          else { //pop-ups if not valid
              System.out.println("Invalid email or password!");
              Alert alert = new Alert(Alert.AlertType.ERROR);
              if(!isValidEmail(email)) {
                  createErrorAlert("Invalid Email", "Please enter a valid email address");
              } else if(!isValidPassword(password)) {
                  createErrorAlert("Invalid Password", "Please enter a valid password");
              } else if(!repeatPassword.equals(password)) {
                  createErrorAlert("Invalid Passwords", "Passwords do not match");
              }
          }
         });

         signUp_LoginButton.setOnAction(actionEvent -> {
             System.out.println("Login button pressed!");
             Model.getInstance().getViewFactory().showLogin();
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
                //JOptionPane.showMessageDialog(null, "Password: Does not meet requirements");
                return false;
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Password: Contains invalid characters");
            return false;
        }
        return true;
    }

    public void createErrorAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
    }
}


