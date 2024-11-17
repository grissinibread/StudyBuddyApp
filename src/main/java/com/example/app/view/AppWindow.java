package main.java.com.example.app.view;

import main.java.com.example.app.util.FontManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class AppWindow extends JFrame {
    public AppWindow() {
        setTitle("Study Buddy");
        setUndecorated(true); // removes default title bar
        GridBagConstraints frameConstraints = new GridBagConstraints();
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // rounds the corners of the window
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

        // setting custom logo
        ImageIcon logo = new ImageIcon("src/resources/img/logo.png");
        setIconImage(logo.getImage());

        // opens the window in the center of the screen
        setLocationRelativeTo(null);

        // adds the login screen to this window
        LoginPage loginPage = new LoginPage();
        add(loginPage, BorderLayout.CENTER);

        // discoverPage view
        DiscoverPage discoverPage = new DiscoverPage();

        //Sign Up Button
        SignUpPage signUpPage = new SignUpPage();
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(FontManager.getCustomFont(12));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 8;
        loginPage.add(signUpButton, frameConstraints);
        // TODO: MOVE BUTTON TO PROPER JAVA FILE

        // When Sign Up Button is pressed, it takes you to the Sign Up Page.
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPage(signUpPage);
            }
        });
        // TODO: MOVE LOGIC TO PROPER JAVA FILE

        //Makes and displays a Back to Login Button.
        JButton backToLoginButton = new JButton("Back to Login");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        signUpPage.add(backToLoginButton, frameConstraints);
        // TODO: MOVE BUTTON TO PROPER JAVA FILE (LOGIN PAGE)

        // Pressing the "Back to Login" button takes the user
        // back to the login screen.
        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {openPage(loginPage);
            }
        });
        // TODO: MOVE LOGIC TO PROPER JAVA FILE (SIGN UP PAGE)
    }

    public void openPage(JPanel page) {
        setContentPane(page);
        revalidate();
        repaint();
    }
}

