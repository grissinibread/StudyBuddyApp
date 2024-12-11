package com.example.app.view;

import com.example.app.controller.SignUpController;
import com.example.app.controller.LoginController;
import com.example.app.controller.DiscoverController;
import com.example.app.controller.ProfileController;
import com.example.app.util.FontManager;
import com.example.app.model.User;

import javax.swing.*;
import java.awt.*;

public final class SignUpPage extends JPanel {
    //Initializes the one instance of a Sign Up page to be used by the rest of the program.
    private static final SignUpPage signUpPage = new SignUpPage();
    //Initializes the sign up controller to be used by the class.
    private final SignUpController signUpController;
    //Initializes the login controller to be used by the class.
    private final LoginController loginController;
    //Initializes the profile controller to be used by the class.
    private final ProfileController profileController;
    //Initializes the discover controller to be used by the class.
    private final DiscoverController discoverController;
    private User user;

    //Initialize these objects so that it is possible to access them on other methods
    // (Mainly to clear them/make them default when the page is changed).
    private JTextArea firstNameBox;
    private JTextArea lastNameBox;
    private JTextArea emailBox;
    private JPasswordField passwordBox;
    private JPasswordField confirmPasswordBox;
    private JTextArea ageBox;

    String majorArray[] = {"Computer Science", "Software Engineering", "Computer Engineering", "Cyber Security",
            "Computer Information Systems", "Electrical Engineering", "Mathematics", "Applied Physics",
            "Electronics", "Biochemistry", "Chemistry", "Biotechnology", "Biological Sciences",
            "Wildfire Science & the Urban Interface"};

    Integer yearArray[] = {2024, 2025, 2026, 2027, 2028};

    private JComboBox<String> majorComboBox = new JComboBox(majorArray);
    private JComboBox<Integer> gradYearComboBox = new JComboBox(yearArray);
    private String major; // holds major selection
    private Integer gradYear; // holds gradYear selection

    //Sign Up page constructor.
    private SignUpPage() {
        //Initializes the sign-up controller to be used by the class.
        this.signUpController = new SignUpController();
        //Initializes the login controller to be used by the class.
        this.loginController = new LoginController();
        //Initializes the profile controller to be used by the class.
        this.profileController = new ProfileController();
        //Initializes the discover controller to be used by the class.
        this.discoverController = new DiscoverController();

        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        // Title
        addLabel("Sign Up", 50, frameConstraints, 0, 1, 25);

        // First Name and Last Name
        firstNameBox = addLabeledTextField("First Name", frameConstraints, 0, 2);
        lastNameBox = addLabeledTextField("Last Name", frameConstraints, 2, 2);

        // Email
        emailBox = addLabeledTextField("Email", frameConstraints, 0, 3);

        // Password and Confirm Password
        passwordBox = addLabeledPasswordField("Password", frameConstraints, 0, 4);
        confirmPasswordBox = addLabeledPasswordField("Confirm Password", frameConstraints, 0, 5);

        // Age
        ageBox = addLabeledTextField("Age", frameConstraints, 0, 6);

        // Major ComboBox
        this.addLabel("Major", 15, frameConstraints, 0, 7, 25);
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 7;
        this.add(majorComboBox, frameConstraints);

        // Graduation Year ComboBox
        this.addLabel("Graduation Year", 15, frameConstraints, 0, 8, 25);
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 8;
        this.add(gradYearComboBox, frameConstraints);

        // Sign Up Button
        addSignUpButton(firstNameBox, lastNameBox, emailBox, passwordBox, confirmPasswordBox, ageBox,
                frameConstraints, 3, 8);

        // Back to Login Button
        addBackToLoginButton(frameConstraints);
    }

    //Returns the one instance of the signUpPage.
    public static SignUpPage getSignUpPage()
    {
        return signUpPage;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        Color color1 = Color.decode("#FFCC33"); // Darker yellow
        Color color2 = Color.decode("#FFFF99"); // Light yellow
        Color color3 = Color.decode("#FFB6C1"); // Light pink
        GradientPaint gradient = new GradientPaint(0, 0, color3, width, height, color2);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
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

    // T0DO: ADD MAJOR AND YEAR INTO PARAMETERS
    private void handleSignUp(String first, String last, String email, String password, String confirmPass, String ageText) {
        int age = Integer.parseInt(ageText);
        major = (String) majorComboBox.getSelectedItem(); // extracts from major box
        gradYear = (Integer) gradYearComboBox.getSelectedItem(); // extracts from gradYear box
        System.out.println("User:" + first + " " + last + " " + email + " " + password + " " + confirmPass + " " + age + " " + major + " " + gradYear);
        if (signUpController.verifySignUp(first, last, email, password, confirmPass, age, major, gradYear)) {
            if (major == null){ System.out.println("Major is null"); }
            else {user.setMajor(major);}
            if (gradYear == 0){ System.out.println("Grad Year is null"); }
            else { user.setYear(gradYear);}
            // Navigate to the next page
            System.out.println("SignUp successful");
            profileController.goToProfilePage();
            //TODO: Might have to double check this but most likely not.
            clearSignUpChoice();
            //discoverController.goToDiscoverPage();
        }
    }

    private void addBackToLoginButton(GridBagConstraints constraints) {
        JButton backToLoginButton = new JButton("Back to Login");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(backToLoginButton, constraints);

        backToLoginButton.addActionListener(e -> {
            loginController.goToLoginPage();
            clearSignUpChoice();
        });
    }

    //Makes it so that every input in the sign-up page is reset to default.
    private void clearSignUpChoice() {
        firstNameBox.setText(null);
        lastNameBox.setText(null);
        emailBox.setText(null);
        passwordBox.setText(null);
        confirmPasswordBox.setText(null);
        ageBox.setText(null);
        majorComboBox.setSelectedIndex(0);
        gradYearComboBox.setSelectedIndex(0);
    }
}
