package main.java.com.example.app.view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

public class AppWindow extends JFrame {
    public AppWindow() {
        setTitle("Study Buddy");
        setUndecorated(true); // removes default title bar

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
    }
}
