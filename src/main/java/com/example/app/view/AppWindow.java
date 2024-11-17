package main.java.com.example.app.view;

import main.java.com.example.app.util.FontManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

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

        //Makes and displays a Back to Login Button.
        JButton backToLoginButton = new JButton("Back to Login");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        signUpPage.add(backToLoginButton, frameConstraints);
        // TODO: MOVE BUTTON TO PROPER JAVA FILE

        // Pressing the "Back to Login" button takes the user
        // back to the login screen.
        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {openPage(loginPage);
            }
        });

        //Sign Up Button
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

        // Enable dragging
        enableWindowDrag(AppWindow.this);
    }

    public void openPage(JPanel page)
    {
        setContentPane(page);
        revalidate();
        repaint();
    }

    private static void enableWindowDrag(JFrame frame) {
        // Variables to store initial click location
        final Point[] initialClick = {null};

        // Add mouse listeners to the frame's content pane
        frame.getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Store the point where the mouse is clicked
                initialClick[0] = e.getPoint();
            }
        });

        frame.getContentPane().addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Get the current location of the frame
                Point currentScreenLocation = frame.getLocationOnScreen();
                Point mouseDraggedLocation = e.getPoint();

                // Calculate the new location of the frame
                int xMoved = mouseDraggedLocation.x - initialClick[0].x;
                int yMoved = mouseDraggedLocation.y - initialClick[0].y;

                int newX = currentScreenLocation.x + xMoved;
                int newY = currentScreenLocation.y + yMoved;

                frame.setLocation(newX, newY);
            }
        });
    }
}

