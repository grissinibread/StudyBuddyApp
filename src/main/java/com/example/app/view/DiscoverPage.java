package com.example.app.view;

import com.example.app.controller.DiscoverController;
import com.example.app.util.FontManager;
import com.example.app.util.RoundedPanel;
import com.example.app.controller.LoginController;
import com.example.app.controller.ProfileController;
import com.example.app.controller.ConnectionsController;

import javax.swing.*;
import java.awt.*;

public final class DiscoverPage extends JPanel {
    //Initializes the login controller to be used by the class.
    private final LoginController loginController;
    //Initializes the profile controller to be used by the class.
    private final ProfileController profileController;
    //Initializes the inbox controller to be used by the class.
    private final ConnectionsController connectionsController;
    // Initializes the discover controller to be used by the class.
    private DiscoverController discoverController;

    //Initializes the one instance of a Discover Page to be used by the rest of the program.
    private static final DiscoverPage CONNECTIONS_PAGE = new DiscoverPage();

    //Discover Page constructor.
    private DiscoverPage() {

        //Initializes the login controller to be used by the class.
        this.loginController = new LoginController();

        //Initializes the profile controller to be used by the class.
        this.profileController = new ProfileController();

        //Initializes the inbox controller to be used by the class.
        this.connectionsController = new ConnectionsController();

        //Initializes the inbox controller to be used by the class.
        this.discoverController = new DiscoverController();

        setLayout(new BorderLayout());

        // Top Nav Bar
        add(topNav(), BorderLayout.NORTH);

        // Main Content
        add(mainContent(), BorderLayout.CENTER);

        // Left Nav Bar;
        add(bottomNav(), BorderLayout.SOUTH);


    }

    //Returns the one instance of the discoverPage.
    public static DiscoverPage getDiscoverPage() { return CONNECTIONS_PAGE; }

    private JPanel topNav() {
        JPanel topNav = new JPanel();
        topNav.setLayout(new GridBagLayout());
        topNav.setBackground(Color.WHITE);
        GridBagConstraints constraints = new GridBagConstraints();
        topNav.setPreferredSize(new Dimension(getWidth(), 75));

        // Profile Icon
        ImageIcon original = new ImageIcon("src/resources/img/profileFiller.png");
        Image scaled = original.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon profile = new ImageIcon(scaled);
        JButton profileIcon = new JButton(profile);
        profileIcon.setBorderPainted(false);
        profileIcon.setContentAreaFilled(false);
        profileIcon.setFocusPainted(false);
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.WEST;
        topNav.add(profileIcon, constraints);
        profileIcon.addActionListener(e -> profileController.goToProfilePage());

        // Title of the page
        JLabel titleLabel = new JLabel("Discover");
        titleLabel.setFont(FontManager.getCustomFont(25).deriveFont(Font.BOLD));
        titleLabel.setForeground(Color.decode("#87CEFA"));
        constraints.gridx = 1;
        constraints.weightx = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        topNav.add(titleLabel, constraints);

        // logoutIcon
        ImageIcon originalIcon = new ImageIcon("src/resources/img/logout.jpeg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon logout = new ImageIcon(scaledImage);
        JButton logoutButton = new JButton(logout);
        logoutButton.addActionListener(e -> loginController.goToLoginPage());

        // Optional: Customize button (e.g., remove border and focus)
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(false); // Transparent background
        logoutButton.setFocusPainted(false);
        logoutButton.setToolTipText("Logout"); // Add a tooltip

        constraints.gridx = 2;
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.EAST;
        topNav.add(logoutButton, constraints);
        // TODO: BACKEND

        return topNav;
    }

    private JPanel bottomNav() {
        JPanel bottomNav = new JPanel();
        bottomNav.setBackground(Color.WHITE);
        bottomNav.setLayout(new GridBagLayout());
        bottomNav.setPreferredSize(new Dimension(getWidth(), 60));
        GridBagConstraints constraints = new GridBagConstraints();

        // Inbox Icon
        ImageIcon originalIcon = new ImageIcon("src/resources/img/Inbox.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon inbox = new ImageIcon(scaledImage);
        JButton messagesIcon = new JButton(inbox);
        messagesIcon.setPreferredSize(new Dimension(40, 40));
        messagesIcon.setBorderPainted(false);
        messagesIcon.setContentAreaFilled(false);
        messagesIcon.setFocusPainted(false);
        messagesIcon.setToolTipText("Inbox");
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 1;
        constraints.insets = new Insets(0, 20, 20, 0);
        bottomNav.add(messagesIcon, constraints);
        // TODO: BACKEND? - Axel
        messagesIcon.addActionListener(e -> connectionsController.goToInboxPage());

        // Matching button
        JButton matchButton = new JButton("Get More Matches");
        matchButton.setFont(FontManager.getCustomFont(12));
        constraints.insets = new Insets(0, 0, 20, 60);
        bottomNav.add(matchButton, constraints);
        matchButton.addActionListener(e -> discoverController.getMatches());
        return bottomNav;
    }

    private JPanel mainContent() {
        JPanel mainContent = new JPanel();
        mainContent.setBackground(Color.WHITE);
        mainContent.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // TODO: CONNECT TO BACKEND (RELEVANT USER INFO OTHERS WOULD PROBABLY LIKE TO KNOW)

        int cols = 1;
        int rows = 1;

        constraints.insets = new Insets(10, 10, 10, 10);

        for(int i = 0; i <= rows; i++) {
            constraints.gridx = i;
            for(int j = 0; j <= cols; j++) {
                constraints.gridy = j;
                mainContent.add(profileTemplate(), constraints);
            }
        }

        return mainContent;
    }

//    private void addMatchButton(GridBagConstraints constraints) {
//        JButton matchButton = new JButton("Get Matches");
//        matchButton.setFont(FontManager.getCustomFont(12));
//        constraints.gridx = 0;
//        constraints.gridy = 5;
//        constraints.insets = new Insets(0, 0, 5, 0);
//        add(matchButton, constraints);
//        constraints.insets = new Insets(0, 0, 0, 0); // reset constraints
//
//        //loginButton.addActionListener(e -> discoverController.getMatches(user));
//    }

    private JPanel profileTemplate() {
        // Create a custom rounded JPanel
        JPanel profileCard = new RoundedPanel(20);
        profileCard.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        profileCard.setPreferredSize(new Dimension(375, 200));
        profileCard.setBackground(Color.decode("#87CEFA"));

        // Addition of Image
        ImageIcon profilePicture = new ImageIcon("src/resources/img/profileFiller.png");
        Image scaled = profilePicture.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon profileIcon = new ImageIcon(scaled);
        JLabel profilePictureLabel = new JLabel(profileIcon);
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(30, 30, 0, 0);
        profileCard.add(profilePictureLabel, constraints);

        // TODO: GET ACCOUNT INFO FROM DATABASE FOR ALL OF THE FOLLOWING SECTIONS

        // Name of the user
        JLabel userName = new JLabel("REPLACE WITH NAME");
        userName.setFont(FontManager.getCustomFont(15).deriveFont(Font.BOLD));
        userName.setForeground(Color.WHITE); // To make text visible against the black background
        constraints.insets = new Insets(30, 150, 0, 0);
        profileCard.add(userName, constraints);

        // Graduation Year
        JLabel graduationYear = new JLabel("Graduation Year: ");
        graduationYear.setFont(FontManager.getCustomFont(12).deriveFont(Font.BOLD));
        constraints.insets = new Insets(60, 150, 0, 0);
        graduationYear.setForeground(Color.WHITE);
        profileCard.add(graduationYear, constraints);

        // Major of user
        JLabel major = new JLabel("REPLACE WITH MAJOR");
        major.setFont(FontManager.getCustomFont(15).deriveFont(Font.BOLD));
        major.setForeground(Color.WHITE);
        constraints.insets = new Insets(0, 30, 0, 0);
        constraints.gridy = 1;
        profileCard.add(major, constraints);

        // TODO: BACKEND OF BUTTON
        // Connect button
        JButton connectButton = new JButton("Connect");
        connectButton.setFont(FontManager.getCustomFont(12));
        constraints.insets = new Insets(-10, 0, 0, 30);
        connectButton.setForeground(Color.BLACK);
        constraints.anchor = GridBagConstraints.EAST;
        profileCard.add(connectButton, constraints);

        return profileCard;
    }
}

// TODO: TEST MATCHING