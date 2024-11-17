package com.example.app.view;

import com.example.app.util.FontManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class AppWindow extends JFrame {

    public AppWindow() {
        // Basic window settings
        setTitle("Study Buddy");
        setUndecorated(true); // Removes default title bar
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Opens the window in the center of the screen
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20)); // Rounds the corners
        setIconImage(new ImageIcon("src/resources/img/logo.png").getImage()); // Custom logo

        // Layout settings
        setLayout(new BorderLayout());

        // Pages
        LoginPage loginPage = new LoginPage();
        SignUpPage signUpPage = new SignUpPage();
        ProfilePage profilePage = new ProfilePage();
        DiscoverPage discoverPage = new DiscoverPage(); // Not used in this example, but included for context

        // Add the Login page by default
        // add(loginPage, BorderLayout.CENTER);
        // add(profilePage, BorderLayout.CENTER);

        // Sign Up Button
        addSignUpButton(loginPage, signUpPage);

        // Back to Login Button
        addBackToLoginButton(signUpPage, loginPage);
    }

    private void addSignUpButton(LoginPage loginPage, SignUpPage signUpPage) {
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(FontManager.getCustomFont(12));

        GridBagConstraints frameConstraints = new GridBagConstraints();
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 8;
        loginPage.add(signUpButton, frameConstraints);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPage(signUpPage);
            }
        });
    }

    private void addBackToLoginButton(SignUpPage signUpPage, LoginPage loginPage) {
        JButton backToLoginButton = new JButton("Back to Login");

        GridBagConstraints frameConstraints = new GridBagConstraints();
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        signUpPage.add(backToLoginButton, frameConstraints);

        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPage(loginPage);
            }
        });
    }

    // Open a specific page inside the window
    public void openPage(JPanel page) {
        setContentPane(page);
        revalidate();
        repaint();
    }
}
