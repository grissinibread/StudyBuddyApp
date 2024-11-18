package com.example.app.view;

import javax.swing.*;
import java.awt.*;

// TODO: Make this file one instance/singleton model.
public class MessagesPage extends JPanel {
    public MessagesPage() {
        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Messages");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        add(titleLabel, frameConstraints);
    }
}
