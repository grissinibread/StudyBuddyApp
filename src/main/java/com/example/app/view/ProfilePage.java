package com.example.app.view;

import com.example.app.model.User;
import com.example.app.util.FontManager;
import com.example.app.controller.ProfileController;
import com.example.app.controller.DiscoverController;
import com.example.app.controller.SettingsController;

import javax.swing.*;
import java.awt.*;

public final class ProfilePage extends JPanel {
    //Initializes the one instance of a Profile Page to be used by the rest of the program.
    private static final ProfilePage profilePage = new ProfilePage();
    private User user = User.getUser();
    private final ProfileController profileController = new ProfileController();
    private final DiscoverController discoverController = new DiscoverController();
    private final SettingsController settingsController = new SettingsController();

    //Profile Page constructor.
    private ProfilePage() {
        setLayout(new BorderLayout());

        // top panel
        add(topPanel(), BorderLayout.NORTH);

        // main panel
        add(mainPanel(), BorderLayout.CENTER);
    }

    //Returns the one instance of the profilePage.
    public static ProfilePage getProfilePage() {
        return profilePage;
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
        backButton.addActionListener(e -> {discoverController.goToDiscoverPage();});

        // Edit profile button
        JButton editProfileButton = new JButton("Edit Profile");
        constraints.insets = new Insets(0, 0, 0, 10);
        constraints.anchor = GridBagConstraints.EAST;
        topPanel.add(editProfileButton, constraints);
        editProfileButton.addActionListener(e -> {settingsController.goToSettingsPage();});

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

        // Profile Picture

        // Added Picture
        // TODO: Nice have

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
        JLabel userName = new JLabel(profileController.capitalizedName());
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
        JLabel descriptionText = new JLabel(profileController.displayBio()); // temporary text
        descriptionText.setFont(FontManager.getCustomFont(14));
        constraints.insets = new Insets(120, 0, 0, 0); // TEMPORARY SOLUTION
        mainPanel.add(descriptionText, constraints);

        // Major
        JLabel majorLabel = new JLabel("Major");
        majorLabel.setFont(FontManager.getCustomFont(16).deriveFont(Font.BOLD));
        constraints.insets = new Insets(150, 0, 0, 0); // TEMPORARY SOLUTION
        mainPanel.add(majorLabel, constraints);

        // Major text
        JLabel majorText = new JLabel(profileController.displayMajor());
        majorText.setFont(FontManager.getCustomFont(14));
        constraints.insets = new Insets(180, 0, 0, 0);
        mainPanel.add(majorText, constraints);

        // Interests
        JLabel interestsLabel = new JLabel("Interests");
        interestsLabel.setFont(FontManager.getCustomFont(16).deriveFont(Font.BOLD));
        constraints.insets = new Insets(210,0,0,0); // TEMPORARY SOLUTION
        mainPanel.add(interestsLabel, constraints);

        // Interests Array
        JLabel interestsText = new JLabel(profileController.displayInterests());
        interestsText.setFont(FontManager.getCustomFont(14));
        constraints.insets = new Insets(240, 0, 0, 0); // TEMPORARY SOLUTION
        mainPanel.add(interestsText, constraints);

        return mainPanel;
    }

}