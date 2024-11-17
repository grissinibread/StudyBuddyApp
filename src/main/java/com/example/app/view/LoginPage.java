package main.java.com.example.app.view;

import main.java.com.example.app.controller.SignUpController;
import main.java.com.example.app.util.FontManager;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JPanel {
    private final SignUpController signUpController;

    public LoginPage() {
        this.signUpController = new SignUpController();
        initializeUI();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        Color color1 = Color.decode("#87CEFA"); // Light blue
        Color color2 = Color.decode("#FFFFFF"); // White
        GradientPaint gradient = new GradientPaint(0, 0, color1, width, height, color2);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }

    private void initializeUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Title Label
        addTitleLabel(constraints);

        // Email Section
        JTextArea emailTextBox = addLabeledTextField("Email", constraints, 1);

        // Password Section
        JPasswordField passwordTextBox = addPasswordField("Password", constraints, 3);

        // Login Button
        addLoginButton(emailTextBox, passwordTextBox, constraints);

        // Forgot Password Button
        addForgotPasswordButton(constraints);

        // Sign-up Option
        addSignUpOption(constraints);
    }

    private void addTitleLabel(GridBagConstraints constraints) {
        JLabel titleLabel = new JLabel("Study Buddy");
        titleLabel.setFont(FontManager.getCustomFont(50).deriveFont(Font.BOLD));
        titleLabel.setForeground(Color.decode("#000000"));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 25, 0);
        add(titleLabel, constraints);
    }

    private JTextArea addLabeledTextField(String labelText, GridBagConstraints constraints, int row) {
        createLabel(labelText, constraints, row);

        JTextArea textBox = new JTextArea();
        textBox.setPreferredSize(new Dimension(200, 18));
        constraints.gridy = row + 1;
        constraints.insets = new Insets(0, 0, 10, 0);
        add(textBox, constraints);

        return textBox;
    }

    private JPasswordField addPasswordField(String labelText, GridBagConstraints constraints, int row) {
        createLabel(labelText, constraints, row);

        JPasswordField passwordBox = new JPasswordField();
        passwordBox.setPreferredSize(new Dimension(200, 18));
        constraints.gridy = row + 1;
        constraints.insets = new Insets(0, 0, 10, 0);
        add(passwordBox, constraints);

        return passwordBox;
    }

    private void createLabel(String labelText, GridBagConstraints constraints, int row) {
        JLabel label = new JLabel(labelText);
        label.setFont(FontManager.getCustomFont(16));
        label.setForeground(Color.decode("#4A4A4A"));
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.insets = new Insets(0, 0, 0, 0); // inset reset
        add(label, constraints);
    }

    private void addLoginButton(JTextArea emailTextBox, JPasswordField passwordTextBox, GridBagConstraints constraints) {
        JButton loginButton = new JButton("Login");
        loginButton.setFont(FontManager.getCustomFont(12));
        constraints.gridx = 0;
        constraints.gridy = 5;
        add(loginButton, constraints);

        loginButton.addActionListener(e -> handleLogin(emailTextBox.getText(), passwordTextBox.getText()));
    }

    private void handleLogin(String email, String password) {
        if (signUpController.verifySignUp(email, password)) {
            // Navigate to the next page
            System.out.println("Login successful");
            // Example: appWindow.openPage(new DiscoverPage());
        }
    }

    private void addForgotPasswordButton(GridBagConstraints constraints) {
        JButton forgotPasswordButton = new JButton("Forgot Password?");
        forgotPasswordButton.setFont(FontManager.getCustomFont(12));
        constraints.gridy = 6;
        add(forgotPasswordButton, constraints);
        // TODO: Add action listener for password retrieval
    }

    private void addSignUpOption(GridBagConstraints constraints) {
        JLabel signUpLabel = new JLabel("Don't have an account?");
        signUpLabel.setFont(new Font("Serif", Font.BOLD, 12));
        signUpLabel.setForeground(Color.decode("#4A4A4A"));
        constraints.gridy = 7;
        add(signUpLabel, constraints);
        // TODO: Add a sign-up button
    }
}
