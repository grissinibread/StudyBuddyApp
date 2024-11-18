package com.example.app.view;

import com.example.app.util.FontManager;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public final class AppWindow extends JFrame {

    private static final AppWindow appWindow = new AppWindow();

    private AppWindow() {
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

        // Login and Sign Up pages are already initialized in their respective class file.
        //LoginPage loginPage = new LoginPage();
        //SignUpPage signUpPage = new SignUpPage();
        ProfilePage profilePage = new ProfilePage();
        //DiscoverPage discoverPage = new DiscoverPage(); // Not used in this example, but included for context

        // Add the Login page by default
        add(LoginPage.getLoginPage(), BorderLayout.CENTER);
    }

    //Returns the one instance of the AppWindow.
    public static AppWindow getAppWindow()
    {
        return appWindow;
    }

    // Open a specific page inside the window
    public void openPage(JPanel page) {
        setContentPane(page);
        revalidate();
        repaint();
    }
}
