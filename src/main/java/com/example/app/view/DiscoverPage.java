package com.example.app.view;

import javax.swing.*;
import java.awt.*;

public class DiscoverPage extends JPanel {
    //private DiscoverController discoverController;
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
        ImageIcon settings = new ImageIcon("Code/view/img/settings.png", "Settings Icon");
        JButton settingsIcon = new JButton(settings);
        frameConstraints.gridx = 3;
        frameConstraints.gridy = 0;
        add(settingsIcon, frameConstraints);
        // TODO: BACKEND

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

    public void profileTemplate() {
        // creates the template for the profiles
    }
}
