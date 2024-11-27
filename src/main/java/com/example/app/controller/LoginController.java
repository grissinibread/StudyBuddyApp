package com.example.app.controller;

import com.example.app.view.AppWindow;
import com.example.app.view.LoginPage;
import com.example.app.model.User;

import javax.swing.*;

public class LoginController {
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
        return emailValid(email) && passwordValid(password); // these will eventually be replaced with checking against database
    }
}