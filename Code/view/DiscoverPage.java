package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DiscoverPage extends JPanel {
    public DiscoverPage() {
        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        // Navigation Buttons on the left side
        // Profile Icon
        JButton profileIcon = new JButton("Profile Icon");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        add(profileIcon, frameConstraints);
        // TODO: BACKEND

        // Message Icon
        JButton messagesIcon = new JButton("Message Icon");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 1;
        add(messagesIcon, frameConstraints);
        // TODO: BACKEND

        // groupsIcon
        JButton groupsIcon = new JButton("Groups Icon");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 2;
        add(groupsIcon, frameConstraints);
        // TODO: BACKEND

        // Title of the page
        // Create a label with the title text
        JLabel titleLabel = new JLabel("Discover");
        // Set the font size and style for the title
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Font size 24 and bold style
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 0;
        // Add the label to the frame
        add(titleLabel, frameConstraints);

        // Search Bar
        JTextArea searchBox = new JTextArea();
        searchBox.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 2;
        frameConstraints.gridy = 0;
        add(searchBox, frameConstraints);
        // TODO: BACKEND

        // settingsIcon
        JButton settingsIcon = new JButton("Settings Icon");
        frameConstraints.gridx = 3;
        frameConstraints.gridy = 0;
        add(settingsIcon, frameConstraints);
        // TODO: BACKEND
    }

    public void profileTemplate() {
        // creates the template for the profiles
    }
}
