package com.example.app.view;

import javax.swing.*;
import java.awt.*;

public final class ConnectionsPage extends JPanel {
    //Initializes the one instance of an Inbox Page to be used by the rest of the program.
    private static final ConnectionsPage CONNECTIONS_PAGE = new ConnectionsPage();

    //Inbox Page constructor.
    private ConnectionsPage() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //IDK
        add(addTitleLabel("This is the inbox page.", constraints));
    }

    //Returns the one instance of the inboxPage.
    public static ConnectionsPage getInboxPage() {
        return CONNECTIONS_PAGE;
    }

    // TODO: Setup Inbox Page entirely. Anything below this can be deleted when doing the TODO.
    private JLabel addTitleLabel(String text, GridBagConstraints constraints) {
        JLabel label = new JLabel();
        label.setText(text);
        add(label, constraints);
        return label;
    }
}
