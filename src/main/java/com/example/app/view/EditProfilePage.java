package com.example.app.view;

import com.example.app.controller.ProfileController;
import com.example.app.controller.UserSession;
import com.example.app.model.User;
import com.example.app.util.FontManager;

import javax.swing.*;
import java.awt.*;

public class EditProfilePage extends JPanel {

    //Initializes the one instance of a EditProfile Page to be used by the rest of the program.
    private static final com.example.app.view.EditProfilePage editProfilePage = new com.example.app.view.EditProfilePage();
    private User user = UserSession.getLoggedInUser();
    private final ProfileController profileController = new ProfileController();
    // private final EditProfileController editProfileController = new EditProfileController();

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
        backButton.addActionListener(e -> {
            profileController.goToProfilePage();});

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

        // default contraints
        int topConstraint = 25;
        // first name
        constraints.insets = new Insets(topConstraint, 0, 0, 0);
        JPanel userFname = createEditableTextField("First Name", user.getFName(), constraints, 200, 20);
        mainPanel.add(userFname, constraints);
        topConstraint += 50;

        // last name
        constraints.insets = new Insets(topConstraint, 0, 0, 0);
        JPanel userLname = createEditableTextField("Last Name", user.getLName(), constraints, 200, 20);
        mainPanel.add(userLname, constraints);
        topConstraint += 50;

        // Age
        constraints.insets = new Insets(topConstraint, 0, 0, 0);
        JPanel userAge = createEditableTextField("Age", "temp age", constraints, 200, 20);
        mainPanel.add(userAge, constraints);
        topConstraint += 50;

        // Major
        constraints.insets = new Insets(topConstraint, 0, 0, 0);
        JPanel userMajor = createEditableTextField("Major", user.getMajor(), constraints, 200, 20);
        mainPanel.add(userMajor, constraints);
        topConstraint += 50;

        // Description
        constraints.insets = new Insets(topConstraint, 0, 0, 0);
        JPanel userBio = createEditableTextField("Description", user.getBio(), constraints, 400, 100);
        mainPanel.add(userBio, constraints);
        topConstraint += 50;


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
    private JPanel createEditableTextField(String text, String fieldValue, GridBagConstraints constraints, int width, int height) {
        JPanel labeledTextFieldPanel = new JPanel(new GridBagLayout());
        GridBagConstraints fieldConstraints = new GridBagConstraints();
        fieldConstraints.gridx = 0;
        fieldConstraints.gridy = 0;
        fieldConstraints.insets = new Insets(0, 250, 5, 0); // Spacing between label and text field

        // label
        JLabel label = new JLabel(text);
        label.setFont(FontManager.getCustomFont(16).deriveFont(Font.BOLD));
        labeledTextFieldPanel.add(label, fieldConstraints);

        // text field
        fieldConstraints.gridy++;
        JTextField textField = new JTextField(); // width of box
        textField.setPreferredSize(new Dimension(width, height));
        textField.setText(fieldValue);
        textField.setFont(FontManager.getCustomFont(14));
        labeledTextFieldPanel.add(textField, fieldConstraints);

        return labeledTextFieldPanel;
    }
}
