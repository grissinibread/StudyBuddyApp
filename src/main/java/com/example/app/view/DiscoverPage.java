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

        // Left Nav Bar;
        add(leftNav(), BorderLayout.WEST);

        // Main Content
        add(mainContent(), BorderLayout.CENTER);

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
        JButton profileIcon = new JButton("Profile Icon");
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

        // settingsIcon
        ImageIcon settingsIcon = new ImageIcon("src/main/resources/img/settings.png");
        JButton settingsIconButton = new JButton(settingsIcon);
        settingsIconButton.setPreferredSize(new Dimension(40,40));

        // Optional: Customize button (e.g., remove border and focus)
        settingsIconButton.setBorderPainted(false);
        settingsIconButton.setContentAreaFilled(false); // Transparent background
        settingsIconButton.setFocusPainted(false);
        settingsIconButton.setToolTipText("Settings"); // Add a tooltip

        constraints.gridx = 2;
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.EAST;
        topNav.add(settingsIconButton, constraints);
        // TODO: BACKEND

        return topNav;
    }

    private JPanel leftNav() {
        JPanel leftNav = new JPanel();
        leftNav.setBackground(Color.WHITE);
        leftNav.setLayout(new GridBagLayout());
        leftNav.setPreferredSize(new Dimension(100, getHeight()));
        GridBagConstraints constraints = new GridBagConstraints();

        // Message Icon
        JButton messagesIcon = new JButton("Connections");
        constraints.gridx = 0;
        constraints.gridy = 0;
        leftNav.add(messagesIcon, constraints);
        // TODO: BACKEND

        return leftNav;
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
        profileCard.setPreferredSize(new Dimension(300, 150));
        profileCard.setBackground(Color.BLACK);

        JLabel bread = new JLabel("Bread");
        bread.setForeground(Color.WHITE); // To make text visible against the black background
        profileCard.add(bread);

        return profileCard;
    }
}