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
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        return mainPanel;
    }

    public JPanel profileTemplate() {
        JPanel profileTemplate = new JPanel();

        // Panel Properties
        profileTemplate.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        profileTemplate.setPreferredSize(new Dimension(getWidth(), 100));

        return profileTemplate;
    }
}
