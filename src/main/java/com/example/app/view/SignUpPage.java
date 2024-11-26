package com.example.app.view;

import com.example.app.controller.SignUpController;
import com.example.app.controller.LoginController;
import com.example.app.controller.DiscoverController;
import com.example.app.util.FontManager;

import javax.swing.*;
import java.awt.*;

public final class SignUpPage extends JPanel {
    //Initializes the one instance of a Sign Up page to be used by the rest of the program.
    private static final SignUpPage signUpPage = new SignUpPage();

    //Initializes the sign up controller to be used by the class.
    private final DiscoverController discoverController;
    //Initializes the sign up controller to be used by the class.
    private final SignUpController signUpController;
    //Initializes the login controller to be used by the class.
    private final LoginController loginController;

    //Sign Up page constructor.
    private SignUpPage() {
        //Initializes the sign up controller to be used by the class.
        this.signUpController = new SignUpController();
        //Initializes the discover controller to be used by the class.
        this.discoverController = new DiscoverController();
        //Initializes the discover controller to be used by the class.
        this.loginController = new LoginController();

        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        // Title
        addLabel("Sign Up", 50, frameConstraints, 0, 1, 25);

        // First Name and Last Name
        JTextArea firstNameBox = addLabeledTextField("First Name", frameConstraints, 0, 2);
        JTextArea lastNameBox =addLabeledTextField("Last Name", frameConstraints, 2, 2);

        // Email
        JTextArea emailBox =addLabeledTextField("Email", frameConstraints, 0, 3);

        // Password and Confirm Password
        JPasswordField passwordBox =addLabeledPasswordField("Password", frameConstraints, 0, 4);
        JPasswordField confirmPasswordBox = addLabeledPasswordField("Confirm Password", frameConstraints, 0, 5);

        // Age
        JTextArea ageBox =addLabeledTextField("Age", frameConstraints, 0, 6);

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
        addSignUpButton(firstNameBox, lastNameBox, emailBox, passwordBox, confirmPasswordBox, ageBox, frameConstraints, 3, 8);

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

    private JTextArea addLabeledTextField(String labelText, GridBagConstraints constraints, int gridX, int gridY) {
        addLabel(labelText, 15, constraints, gridX, gridY, 10);
        JTextArea textField = new JTextArea();
        textField.setPreferredSize(new Dimension(200, 20));
        constraints.gridx = gridX + 1;
        constraints.gridy = gridY;
        add(textField, constraints);
        return textField;
    }

    private JPasswordField addLabeledPasswordField(String labelText, GridBagConstraints constraints, int gridX, int gridY) {
        addLabel(labelText, 15, constraints, gridX, gridY, 10);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 20));
        constraints.gridx = gridX + 1;
        constraints.gridy = gridY;
        add(passwordField, constraints);
        return passwordField;
    }

    private void addComboBox(String labelText, Object[] items, GridBagConstraints constraints, int gridX, int gridY) {
        addLabel(labelText, 15, constraints, gridX, gridY, 10);
        JComboBox<Object> comboBox = new JComboBox<>(items);
        constraints.gridx = gridX + 1;
        constraints.gridy = gridY;
        add(comboBox, constraints);
    }

    private void addSignUpButton(JTextArea firstNameBox, JTextArea lastNameBox, JTextArea emailBox,
                                 JPasswordField passwordBox, JPasswordField confirmPassBox, JTextArea ageBox,
                                 GridBagConstraints constraints, int gridX, int gridY) {
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(FontManager.getCustomFont(15));
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        add(signUpButton, constraints);
        signUpButton.addActionListener(e -> handleSignUp(firstNameBox.getText(), lastNameBox.getText(), emailBox.getText(),
                passwordBox.getText(), confirmPassBox.getText(), ageBox.getText()));
    }

    private void handleSignUp(String first, String last, String email, String password, String confirmPass, String ageText) {
        int age = Integer.parseInt(ageText);
        if (signUpController.verifySignUp(first, last, email, password, confirmPass, age)) {
            // Navigate to the next page
            System.out.println("Login successful");
            discoverController.goToDiscoverPage();
        }
    }

    private void addBackToLoginButton(GridBagConstraints constraints) {
        JButton backToLoginButton = new JButton("Back to Login");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(backToLoginButton, constraints);

        backToLoginButton.addActionListener(e -> loginController.goToLoginPage());
    }
}
