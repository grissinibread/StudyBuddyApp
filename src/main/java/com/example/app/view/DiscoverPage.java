package com.example.app.view;

import com.example.app.util.FontManager;
import com.example.app.util.RoundedPanel;

import javax.swing.*;
import java.awt.*;

public final class DiscoverPage extends JPanel {
    //Initializes the one instance of a Discover Page to be used by the rest of the program.
    private static final DiscoverPage discoverPage = new DiscoverPage();

    //private DiscoverController discoverController;

    //Discover Page constructor.
    private DiscoverPage() {
        setLayout(new BorderLayout());

        // Top Nav Bar
        add(topNav(), BorderLayout.NORTH);

        // Main Content
        add(mainContent(), BorderLayout.CENTER);

        // Left Nav Bar;
        add(bottomNav(), BorderLayout.SOUTH);

        // TESTING MATCH (does not work atm)
//        User user1 = new User("Adria", 21, "Software", 3, "Beach", "Coding", "Music");
//        User user2 = new User("John", 20, "Software", 3, "Beach", "Coding", "Music");
//        settingsIcon.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //loginApproved = Lcontrol.verifySignUp(emailTextBox.getText(), passwordTextBox.getText());
//                discoverController.matchStudents(user1, user2);
//            }
//        });

    }

    //Returns the one instance of the discoverPage.
    public static DiscoverPage getDiscoverPage() { return discoverPage; }

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
        // TODO: BACKEND

        return bottomNav;
    }

    private JPanel mainContent() {
        JPanel mainContent = new JPanel();
        mainContent.setBackground(Color.WHITE);
        mainContent.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // TODO: CONNECT TO BACKEND (PROFILE IMAGE, RELEVANT USER INFO OTHERS WOULD PROBABLY LIKE TO KNOW)

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

    private JPanel profileTemplate() {
        // Create a custom rounded JPanel
        JPanel profileCard = new RoundedPanel(20);
        profileCard.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        profileCard.setPreferredSize(new Dimension(350, 200));
        profileCard.setBackground(Color.ORANGE);

        // Addition of Image (Bread Image Temp)
        // TODO: GET IMAGE FROM DATABASE
        ImageIcon originalIcon = new ImageIcon("src/resources/img/bread.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon profileIcon = new ImageIcon(scaledImage);
        JButton profileIconButton = new JButton(profileIcon);
        profileIconButton.setPreferredSize(new Dimension(40,40));
        profileIconButton.setBorderPainted(false);
        constraints.gridx = 0;
        constraints.gridy = 0;
        profileCard.add(profileIconButton, constraints);

        // TODO: GET ACCOUNT INFO FROM DATABASE

        JLabel bread = new JLabel("Bread");
        bread.setForeground(Color.WHITE); // To make text visible against the black background
        profileCard.add(bread);

        return profileCard;
    }
}