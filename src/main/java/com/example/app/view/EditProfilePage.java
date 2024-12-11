package com.example.app.view;

import com.example.app.controller.ProfileController;
import com.example.app.model.User;
import com.example.app.util.FontManager;

import javax.swing.*;
import java.awt.*;

public class EditProfilePage extends JPanel {

    //Initializes the one instance of a EditProfile Page to be used by the rest of the program.
    private static final com.example.app.view.EditProfilePage editProfilePage = new com.example.app.view.EditProfilePage();
    private User user = User.getUser();
    //private final EditProfileController editProfileController = new EditProfileController();

    //Edit Profile Page constructor.
    private EditProfilePage() {
        setLayout(new BorderLayout());

        // top panel
        add(topPanel(), BorderLayout.NORTH);

        // main panel
        add(mainPanel(), BorderLayout.CENTER);
    }

    //Returns the one instance of the profilePage.
    public static com.example.app.view.EditProfilePage geteditProfilePage() {
        return editProfilePage;
    }

    private JLabel addTitleLabel(String text, GridBagConstraints constraints) {
        JLabel label = new JLabel();
        label.setText(text); // TODO: CONNECT ACTUAL NAME FROM DATABASE
        add(label, constraints);
        return label;
    }

    private JPanel topPanel() {
        // Panel paramters
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(getWidth(), 75));
        topPanel.setBackground(Color.black);
        topPanel.setLayout(new GridBagLayout());

        // Constraints of the grid
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;

        // Back button
        JButton backButton = new JButton("Back");
        constraints.insets = new Insets(0, 10, 0, 0);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 1;
        topPanel.add(backButton, constraints);

        // Edit profile button
        JButton editProfileButton = new JButton("Save");
        constraints.insets = new Insets(0, 0, 0, 10);
        constraints.anchor = GridBagConstraints.EAST;
        topPanel.add(editProfileButton, constraints);

        return topPanel;
    }

    private JPanel mainPanel() {
        // Panel properties
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        // Constraints of the grid
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;

        // Default Picture
        ImageIcon profilePicture = new ImageIcon("src/resources/img/profileFiller.png");
        Image scaled = profilePicture.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon profileIcon = new ImageIcon(scaled);
        JLabel profilePictureLabel = new JLabel(profileIcon);
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(30, 30, 0, 0);
        mainPanel.add(profilePictureLabel, constraints);

        // User name
        JLabel userName = new JLabel("Temp Name");
        userName.setFont(FontManager.getCustomFont(25).deriveFont(Font.BOLD));
        constraints.insets = new Insets(30, 0, 0, 0);
        constraints.gridx = 1;
        mainPanel.add(userName, constraints);

        // Description
        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setFont(FontManager.getCustomFont(16).deriveFont(Font.BOLD));
        constraints.insets = new Insets(90, 0, 0, 0); // TEMPORARY SOLUTION
        mainPanel.add(descriptionLabel, constraints);

        // Description Text/Bio
        JLabel descriptionText = new JLabel("Temp Bio"); // temporary text
        descriptionText.setFont(FontManager.getCustomFont(14));
        constraints.insets = new Insets(120, 0, 0, 0); // TEMPORARY SOLUTION
        mainPanel.add(descriptionText, constraints);

        // Major
        JLabel majorLabel = new JLabel("Major");
        majorLabel.setFont(FontManager.getCustomFont(16).deriveFont(Font.BOLD));
        constraints.insets = new Insets(150, 0, 0, 0); // TEMPORARY SOLUTION
        mainPanel.add(majorLabel, constraints);

        // Major text
        JLabel majorText = new JLabel("Temp Major");
        majorText.setFont(FontManager.getCustomFont(14));
        constraints.insets = new Insets(180, 0, 0, 0);
        mainPanel.add(majorText, constraints);

        // Interests
        JLabel interestsLabel = new JLabel("Interests");
        interestsLabel.setFont(FontManager.getCustomFont(16).deriveFont(Font.BOLD));
        constraints.insets = new Insets(210,0,0,0); // TEMPORARY SOLUTION
        mainPanel.add(interestsLabel, constraints);

        // Interests Array
        JLabel interestsText = new JLabel("Temp Interests");
        interestsText.setFont(FontManager.getCustomFont(14));
        constraints.insets = new Insets(240, 0, 0, 0); // TEMPORARY SOLUTION
        mainPanel.add(interestsText, constraints);

        return mainPanel;
    }
}
