package com.example.app.view;

import javax.swing.*;
import java.awt.*;

public final class ConnectionsPage extends JPanel {
    //Initializes the one instance of a Connections Page to be used by the rest of the program.
    private static final ConnectionsPage connectionsPage = new ConnectionsPage();

    //Connections Page constructor.
    private ConnectionsPage() {
        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Messages");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        add(titleLabel, frameConstraints);
    }

    //Returns the one instance of the connectionsPage.
    public static ConnectionsPage getConnectionsPage() { return connectionsPage; }
}
