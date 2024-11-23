package com.example.app.view;

import com.example.app.controller.SignUpController;
import com.example.app.util.FontManager;

import javax.swing.*;
import java.awt.*;

public final class SignUpPage extends JPanel {
    //Initializes the one instance of a Sign Up page to be used by the rest of the program.
    private static final SignUpPage signUpPage = new SignUpPage();

    //Initializes the sign up controller to be used by the class.
    private final SignUpController signUpController;

    //Sign Up page constructor.
    private SignUpPage() {
        //Initializes the sign up controller to be used by the class.
        this.signUpController = new SignUpController();

        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        // Title
        addLabel("Sign Up", 50, frameConstraints, 0, 1, 25);

        // First Name and Last Name
        addLabeledTextField("First Name", frameConstraints, 0, 2);
        addLabeledTextField("Last Name", frameConstraints, 2, 2);

        // Email
        addLabeledTextField("Email", frameConstraints, 0, 3);

        // Password and Confirm Password
        addLabeledPasswordField("Password", frameConstraints, 0, 4);
        addLabeledPasswordField("Confirm Password", frameConstraints, 0, 5);

        // Age
        addLabeledTextField("Age", frameConstraints, 0, 6);

        // Major ComboBox
        addComboBox("Major", new String[]{
                "Computer Science", "Software Engineering", "Computer Engineering", "Cyber Security",
                "Computer Information Systems", "Electrical Engineering", "Mathematics", "Applied Physics",
                "Electronics", "Biochemistry", "Chemistry", "Biotechnology", "Biological Sciences",
                "Wildfire Science & the Urban Interface"
        }, frameConstraints, 0, 7);

        // Graduation Year ComboBox
        addComboBox("Graduation Year", new Integer[]{2024, 2025}, frameConstraints, 0, 8);

        // Sign Up Button
        addSignUpButton(frameConstraints, 3, 8);

        // Back to Login Button
        addBackToLoginButton(frameConstraints);
    }

    //Returns the one instance of the signUpPage.
    public static SignUpPage getSignUpPage()
    {
        return signUpPage;
    }

    private void addLabel(String text, int fontSize, GridBagConstraints constraints, int gridX, int gridY, int bottomInset) {
        JLabel label = new JLabel(text);
        label.setFont(FontManager.getCustomFont(fontSize).deriveFont(Font.BOLD));
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.insets = new Insets(0, 0, bottomInset, 0);
        add(label, constraints);
    }

    private void addLabeledTextField(String labelText, GridBagConstraints constraints, int gridX, int gridY) {
        addLabel(labelText, 15, constraints, gridX, gridY, 10);
        JTextArea textField = new JTextArea();
        textField.setPreferredSize(new Dimension(200, 20));
        constraints.gridx = gridX + 1;
        constraints.gridy = gridY;
        add(textField, constraints);
    }

    private void addLabeledPasswordField(String labelText, GridBagConstraints constraints, int gridX, int gridY) {
        addLabel(labelText, 15, constraints, gridX, gridY, 10);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 20));
        constraints.gridx = gridX + 1;
        constraints.gridy = gridY;
        add(passwordField, constraints);
    }

    private void addComboBox(String labelText, Object[] items, GridBagConstraints constraints, int gridX, int gridY) {
        addLabel(labelText, 15, constraints, gridX, gridY, 10);
        JComboBox<Object> comboBox = new JComboBox<>(items);
        constraints.gridx = gridX + 1;
        constraints.gridy = gridY;
        add(comboBox, constraints);
    }

    private void addSignUpButton(GridBagConstraints constraints, int gridX, int gridY) {
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(FontManager.getCustomFont(15));
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        add(signUpButton, constraints);
        // TODO: Add backend functionality for sign up
    }

    private void addBackToLoginButton(GridBagConstraints constraints) {
        JButton backToLoginButton = new JButton("Back to Login");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(backToLoginButton, constraints);

        backToLoginButton.addActionListener(e -> signUpController.goToLoginPage());
    }
}
