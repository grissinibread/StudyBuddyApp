package main.java.com.example.app.view;
import main.java.com.example.app.util.FontManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage extends JPanel {
    public SignUpPage() {
        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        //Title
        JLabel signUpLabel = new JLabel("Sign Up");
        signUpLabel.setFont(FontManager.getCustomFont(50).deriveFont(Font.BOLD));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 1;
        frameConstraints.insets = new Insets(0, 0, 25, 0);
        add(signUpLabel, frameConstraints);

        // First name
        JLabel firstName = new JLabel("First Name");
        firstName.setFont(FontManager.getCustomFont(15));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 2;
        frameConstraints.insets = new Insets(0, 0, 10, 0);
        add(firstName, frameConstraints);

        JTextArea firstNameField = new JTextArea();
        firstNameField.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 2;
        add(firstNameField, frameConstraints);
        /*TODO: CONNECT BACKEND WORK*/

        // Last Name
        JLabel lastName = new JLabel("Last Name");
        lastName.setFont(FontManager.getCustomFont(15));
        frameConstraints.gridx = 2;
        frameConstraints.gridy = 2;
        frameConstraints.insets = new Insets(0, 10, 0, 30);
        add(lastName, frameConstraints);

        JTextArea lastNameField = new JTextArea();
        lastNameField.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 3;
        frameConstraints.gridy = 2;
        frameConstraints.insets = new Insets(0, 0, 10, 0);
        add(lastNameField, frameConstraints);
        /*TODO: CONNECT BACKEND WORK*/

        // email
        JLabel email = new JLabel("Email");
        email.setFont(FontManager.getCustomFont(15));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 3;
        add(email, frameConstraints);

        JTextArea emailField = new JTextArea();
        emailField.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 3;
        add(emailField, frameConstraints);

        // password
        JLabel password = new JLabel("Password");
        password.setFont(FontManager.getCustomFont(15));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 4;
        add(password, frameConstraints);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 4;
        add(passwordField, frameConstraints);

        JLabel confirmPassword = new JLabel("Confirm Password");
        confirmPassword.setFont(FontManager.getCustomFont(15));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 5;
        add(confirmPassword, frameConstraints);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 5;
        add(confirmPasswordField, frameConstraints);

        // Age
        JLabel age = new JLabel("Age");
        age.setFont(FontManager.getCustomFont(15));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 6;
        add(age, frameConstraints);

        JTextArea ageField = new JTextArea();
        ageField.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 6;
        add(ageField, frameConstraints);

        /*TODO: ASK ABOUT HOW TO IMPLEMENT AGE*/

        // major drop down menu
        JLabel major = new JLabel("Major");
        major.setFont(FontManager.getCustomFont(15));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 7;
        add(major, frameConstraints);

        JComboBox<String> majorComboBox = new JComboBox<String>(new String[]{"Computer Science", "Software Engineering"});
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 7;
        add(majorComboBox, frameConstraints);
        /*TODO: ADD ALL MAJORS THROUGH A LIST FROM CSUSM*/

        /*TODO: YEAR DROP DOWN*/
        JLabel graduationYear = new JLabel("Graduation Year");
        graduationYear.setFont(FontManager.getCustomFont(15));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 8;
        add(graduationYear, frameConstraints);

        JComboBox<Integer> graduationYearComboBox = new JComboBox<Integer>(new Integer[]{2024, 2025});
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 8;
        add(graduationYearComboBox, frameConstraints);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(FontManager.getCustomFont(15));
        frameConstraints.gridx = 3;
        frameConstraints.gridy = 8;
        add(signUpButton, frameConstraints);
        // TODO: BACKEND
    }
}
