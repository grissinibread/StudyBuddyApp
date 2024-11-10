package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupLoginPage extends JPanel {
    private LoginController Lcontrol;
    public SignupLoginPage() {
        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        // Create a label with the title text
        JLabel titleLabel = new JLabel("Study Buddy");

        // Set the font size and style for the title
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Font size 24 and bold style
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        // Add the label to the frame
        add(titleLabel, frameConstraints);

        // Create and add text fields
        // Email input
        JTextArea emailTextBox = new JTextArea();
        emailTextBox.setPreferredSize(new Dimension(200, 20));
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Serif", Font.BOLD, 12));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 1;
        add(emailLabel, frameConstraints);
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 2;
        add(emailTextBox, frameConstraints);
        /*TODO: CONNECT BACKEND WORK*/

        // Password input
        JTextArea passwordTextBox = new JTextArea();
        passwordTextBox.setPreferredSize(new Dimension(200, 20));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 12));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 3;
        add(passwordLabel, frameConstraints);
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 4;
        add(passwordTextBox, frameConstraints);
        /*TODO: CONNECT BACKEND WORK*/

        // Login button
        JButton loginButton = new JButton("Login");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 5;
        add(loginButton, frameConstraints);
        /*TODO: CONNECT BACKEND WORK OF LOGIN*/
        Lcontrol = new LoginController(); // to be able to run functions connected to controller

        // Make the button do something
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attemptLogin(emailTextBox.getText(), passwordTextBox.getText());
            }
        });
    }

    public void attemptLogin(String email, String password) {
        boolean loginSuccess = Lcontrol.verifySignUp(email, password);
        if (loginSuccess) {
            /*TODO: NEXT PAGE CONTROL FUNCTION*/
            System.out.println("Login successful");
            //new DiscoverPage();
        } /*else {
            JOptionPane.showMessageDialog(null, "Sign Up Unsuccessful");
        }*/
    }
}
