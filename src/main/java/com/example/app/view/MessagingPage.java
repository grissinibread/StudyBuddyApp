package com.example.app.view;

import javax.swing.*;
import java.awt.*;

public final class MessagingPage extends JPanel {
    //Initializes the one instance of a Connections Page to be used by the rest of the program.
    private static final MessagingPage connectionsPage = new MessagingPage();

    //Connections Page constructor.
    private MessagingPage() {
        setLayout(new BorderLayout());

        // Top Panel
        add(topPanel(), BorderLayout.NORTH);

        // Main Panel

        // Bottom Panel
        add(bottomPanel(), BorderLayout.SOUTH);
    }

    private JPanel topPanel() {
        // JPanel Properties
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        topPanel.setBackground(Color.GREEN);
        topPanel.setPreferredSize(new Dimension(getWidth(), 75));
        GridBagConstraints frameConstraints = new GridBagConstraints();

        // Back Button
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        frameConstraints.weightx = 0;
        frameConstraints.anchor = GridBagConstraints.WEST;
        JButton backButton = new JButton("Back To Inbox");
        topPanel.add(backButton, frameConstraints);

        // Title of the Page
        frameConstraints.gridx = 1;
        frameConstraints.weightx = 1;
        frameConstraints.anchor = GridBagConstraints.CENTER;
        JLabel titleLabel = new JLabel("Inbox");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD));
        topPanel.add(titleLabel, frameConstraints);

        return topPanel;
    }

    private JPanel bottomPanel() {
        // JPanel Properties
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(Color.GREEN);
        bottomPanel.setPreferredSize(new Dimension(getWidth(), 80));

        // Texting Box
        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(getWidth(), 75));
        bottomPanel.add(textArea);

        // Send Button
        JButton sendButton = new JButton("Send");
        bottomPanel.add(sendButton, BorderLayout.EAST);
        // TODO: BACKEND TO THE DATABASE

        return bottomPanel;
    }


    //Returns the one instance of the connectionsPage.
    public static MessagingPage getConnectionsPage() { return connectionsPage; }
}
