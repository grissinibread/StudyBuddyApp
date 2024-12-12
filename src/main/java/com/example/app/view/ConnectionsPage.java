package com.example.app.view;

import javax.swing.*;
import java.awt.*;

public final class ConnectionsPage extends JPanel {
    //Initializes the one instance of an Inbox Page to be used by the rest of the program.
    private static final ConnectionsPage CONNECTIONS_PAGE = new ConnectionsPage();

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
        topPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Back button
        JButton backButton = new JButton("Back");
        constraints.insets = new Insets(0, 10, 0, 0);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 1;
        topPanel.add(backButton, constraints);

        // Properties
        topPanel.setPreferredSize(new Dimension(getWidth(), 100));

        return topPanel;
    }

    public JPanel mainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();


        return mainPanel;
    }
}
