package com.example.app.view;

import com.example.app.util.FontManager;

import javax.swing.*;
import java.awt.*;
import com.example.app.controller.DiscoverController;

public final class ConnectionsPage extends JPanel {
    //Initializes the one instance of an Inbox Page to be used by the rest of the program.
    private static final ConnectionsPage CONNECTIONS_PAGE = new ConnectionsPage();

    private final DiscoverController discoverController = new DiscoverController();

    //Inbox Page constructor.
    private ConnectionsPage() {
        setLayout(new BorderLayout());

        // Top Nav
        add(topPanel(), BorderLayout.NORTH);

        // Main Content
        add(mainPanel(), BorderLayout.CENTER);
    }

    //Returns the one instance of the inboxPage.
    public static ConnectionsPage getInboxPage() {
        return CONNECTIONS_PAGE;
    }

    public JPanel topPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);

        // Panel Properties
        topPanel.setPreferredSize(new Dimension(getWidth(), 100));
        topPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Back button
        constraints.gridx = 0;
        constraints.gridy = 0;
        JButton backButton = new JButton("Back");
        constraints.insets = new Insets(0, 10, 0, 0);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 1;
        topPanel.add(backButton, constraints);
        backButton.addActionListener(e -> { discoverController.goToDiscoverPage(); });

        // Title
        JLabel connectionsLabel = new JLabel("Connections");
        connectionsLabel.setFont(FontManager.getCustomFont(25).deriveFont(Font.BOLD));
        connectionsLabel.setForeground(Color.decode("#87CEFA"));
        constraints.weightx = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        topPanel.add(connectionsLabel, constraints);

        return topPanel;
    }

    public JPanel mainPanel() {
        JPanel mainPanel = new JPanel();

        // Panel Properties
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Profile Cards
        // TODO: ADD AS MANY AS ARE STORED IN THE DATABASE
        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(profileTemplate(), constraints); // TEMP

        constraints.gridy = 1;
        mainPanel.add(profileTemplate(), constraints); // TEMP

        constraints.gridy = 2;
        mainPanel.add(profileTemplate(), constraints); // TEMP

        constraints.gridy = 3;
        mainPanel.add(profileTemplate(), constraints); // TEMP

        constraints.gridy = 4;
        mainPanel.add(profileTemplate(), constraints); // TEMP

        return mainPanel;
    }

    public JPanel profileTemplate() {
        JPanel profileTemplate = new JPanel();

        // Panel Properties
        profileTemplate.setBackground(Color.ORANGE); // TEMP COLOR
        profileTemplate.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        profileTemplate.setPreferredSize(new Dimension(800, 100));

        // Profile Temp
        constraints.insets = new Insets(0, 10, 0, 0);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;

        ImageIcon profilePicture = new ImageIcon("src/resources/img/profileFiller.png");
        Image scaled = profilePicture.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon profileIcon = new ImageIcon(scaled);
        JLabel profilePictureLabel = new JLabel(profileIcon);
        profileTemplate.add(profilePictureLabel, constraints);

        // User Name
        constraints.gridx = 1;

        JLabel userName = new JLabel("getUserName");
        userName.setFont(FontManager.getCustomFont(12));
        profileTemplate.add(userName, constraints);

        return profileTemplate;
    }
}
