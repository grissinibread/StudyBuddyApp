package main.java.com.example.app.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

public class AppWindow extends JFrame {
    public AppWindow() {
        setTitle("Study Buddy");
        setUndecorated(true); // removes default title bar
        GridBagConstraints frameConstraints = new GridBagConstraints();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // rounds the corners of the window
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

        // setting custom icon
        ImageIcon logo = new ImageIcon("src/resources/img/logo.png");
        setIconImage(logo.getImage());

        // opens the window in the center of the screen
        setLocationRelativeTo(null);

        // adds the login screen to this window
        LoginPage loginPage = new LoginPage();
        add(loginPage);

        SignUpPage signUpPage = new SignUpPage();
        //add(signUpPage);

        // discoverPage view
        DiscoverPage discoverPage = new DiscoverPage();
        //add(discoverPage);

        MessagesPage messagesPage = new MessagesPage();
        //add(messagesPage);

        //Sign Up Button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(Color.decode("#F8E71C"));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 8;
        loginPage.add(signUpButton, frameConstraints);

        // When Sign Up Button is pressed, it takes you to the Sign Up Page.
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPage(signUpPage);
            }
        });

        //Makes and displays a Back to Login Button.
        JButton backToLoginButton = new JButton("Back to Login");
        frameConstraints.gridx = 3;
        frameConstraints.gridy = 8;
        signUpPage.add(backToLoginButton, frameConstraints);

        // Pressing the "Back to Login" button takes the user
        // back to the login screen.
        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPage(loginPage);
            }
        });
    }

    public void openPage(JPanel page)
    {
        setContentPane(page);
        revalidate();
        repaint();
    }
}
