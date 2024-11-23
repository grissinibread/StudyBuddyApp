package com.example.app.view;

import com.example.app.util.FontManager;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public final class AppWindow extends JFrame {

    private static final AppWindow appWindow = new AppWindow();

    private AppWindow() {
        // Setting the title of the application
        setTitle("Study Buddy");

        // Removing the default title bar
        setUndecorated(true);

        // Setting default size of the window
        setSize(800, 600);

        // Closes application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Opens the window in the center of the screen
        setLocationRelativeTo(null);

        // Rounds the corners of the frame
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        setIconImage(new ImageIcon("src/resources/img/logo.png").getImage());

        // Layout settings
        setLayout(new BorderLayout());

        // Add the Login page by default
        add(LoginPage.getLoginPage(), BorderLayout.CENTER);
    }

    //Returns the one instance of the AppWindow.
    public static AppWindow getAppWindow() {
        return appWindow;
    }

    // Open a specific page inside the window
    public void openPage(JPanel page) {
        setContentPane(page);
        revalidate();
        repaint();
    }
}
