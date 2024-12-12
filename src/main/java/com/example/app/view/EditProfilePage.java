package com.example.app.view;

import com.example.app.controller.ProfileController;
import com.example.app.controller.EditProfileController;
import com.example.app.controller.DiscoverController;
import com.example.app.controller.UserSession;
import com.example.app.model.User;
import com.example.app.util.FontManager;

import javax.swing.*;
import java.awt.*;

public final class EditProfilePage extends JPanel {

    //Initializes the one instance of a EditProfile Page to be used by the rest of the program.
    private static final EditProfilePage editProfilePage = new EditProfilePage();
    private User user = UserSession.getLoggedInUser();
    private final ProfileController profileController = new ProfileController();
    private final EditProfileController editProfileController = new EditProfileController();
    private final DiscoverController discoverController = new DiscoverController();

    private String majorArray[] = {"Computer Science", "Software Engineering", "Computer Engineering", "Cyber Security",
            "Computer Information Systems", "Electrical Engineering", "Mathematics", "Applied Physics",
            "Electronics", "Biochemistry", "Chemistry", "Biotechnology", "Biological Sciences",
            "Wildfire Science & the Urban Interface"};
    private Integer yearArray[] = {2024, 2025, 2026, 2027, 2028};
    private String interestArray[] = {"Select Interest", "Anime", "Art", "Baking", "Basketball", "Beach", "Bowling", "Camping", "Chess",
            "Coding", "Concerts", "Cooking", "Cybersecurity", "Digital Art", "E-sports", "Fishing", "Football", "Gardening",
            "Graphic Design", "Gym", "Hiking", "Karate", "K-pop", "Makeup", "Math", "Meditation", "Movies", "Music",
            "Photography", "Reading", "Rock Climbing", "Running", "Science", "Sewing", "Shopping", "Singing", "Skiing",
            "Soccer", "Sports", "Surfing", "Swimming", "Tennis", "Theater", "Thrifting", "Traveling", "Video Games",
            "Vollleyball", "Web Development", "Yoga"};

    private JComboBox<String> majorComboBox = new JComboBox(majorArray);
    private JComboBox<String> interestComboBox = new JComboBox(interestArray);
    private JComboBox<Integer> yearComboBox = new JComboBox(yearArray);
    private JTextField userFname;
    private JTextField userLname;
    private JTextField userAge;
    private JTextField userBio;


    //Edit Profile Page constructor.
    private EditProfilePage() {
        setLayout(new BorderLayout());

        // top panel
        add(topPanel(), BorderLayout.NORTH);

        // main panel
        add(mainPanel(), BorderLayout.CENTER);
    }

    //Returns the one instance of the profilePage.
    public static EditProfilePage getEditProfilePage() {
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
            profileController.goToProfilePage();
        });

        // Edit profile button
        JButton saveButton = new JButton("Save");
        constraints.insets = new Insets(0, 0, 0, 10);
        constraints.anchor = GridBagConstraints.EAST;
        topPanel.add(saveButton, constraints);
        saveButton.addActionListener(e -> {
            System.out.println("Current user: " + user.getName());
            saveProfile();
        });

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
        JLabel fnamelabel = new JLabel("First Name");
        fnamelabel.setFont(FontManager.getCustomFont(14).deriveFont(Font.BOLD));
        constraints.insets = new Insets(topConstraint, 0, 0, 0);
        constraints.gridx = 1;
        mainPanel.add(fnamelabel, constraints);
        constraints.insets = new Insets(topConstraint + 20, 0, 0, 0);
        userFname = createEditableTextField("First Name", user.getFName(), constraints, 200, 20);
        mainPanel.add(userFname, constraints);
        topConstraint += 50;

        // last name
        JLabel Lnamelabel = new JLabel("First Name");
        Lnamelabel.setFont(FontManager.getCustomFont(14).deriveFont(Font.BOLD));
        constraints.insets = new Insets(topConstraint, 0, 0, 0);
        constraints.gridx = 1;
        mainPanel.add(Lnamelabel, constraints);
        constraints.insets = new Insets(topConstraint + 20, 0, 0, 0);
        userLname = createEditableTextField("Last Name", user.getLName(), constraints, 200, 20);
        mainPanel.add(userLname, constraints);
        topConstraint += 50;

        // Age
        JLabel yearlabel = new JLabel("Graduation Year");
        yearlabel.setFont(FontManager.getCustomFont(14).deriveFont(Font.BOLD));
        constraints.insets = new Insets(topConstraint, 0, 0, 0);
        constraints.gridx = 1;
        mainPanel.add(yearlabel, constraints);
        constraints.insets = new Insets(topConstraint + 20, 0, 0, 0);
//        JTextField userLname = createEditableTextField("Last Name", user.getLName(), constraints, 200, 20);
        mainPanel.add(yearComboBox, constraints);
        yearComboBox.setSelectedItem(user.getYear());
        topConstraint += 50;

        // Major
        JLabel majorlabel = new JLabel("Major");
        majorlabel.setFont(FontManager.getCustomFont(14).deriveFont(Font.BOLD));
        constraints.insets = new Insets(topConstraint, 0, 0, 0);
        constraints.gridx = 1;
        mainPanel.add(majorlabel, constraints);
        constraints.insets = new Insets(topConstraint + 20, 0, 0, 0);
//        JTextField userLname = createEditableTextField("Last Name", user.getLName(), constraints, 200, 20);
        mainPanel.add(majorComboBox, constraints);
        majorComboBox.setSelectedItem(user.getMajor());
        topConstraint += 50;

        // Description
        JLabel biolabel = new JLabel("Bio");
        biolabel.setFont(FontManager.getCustomFont(14).deriveFont(Font.BOLD));
        constraints.insets = new Insets(topConstraint, 0, 0, 0);
        constraints.gridx = 1;
        mainPanel.add(biolabel, constraints);
        constraints.insets = new Insets(topConstraint + 20, 0, 0, 0);
        JTextField userBio = createEditableTextField("Age", user.getBio(), constraints, 400, 100);
        mainPanel.add(userBio, constraints);
        topConstraint += 150;

        // Interests

        // TODO: BACKEND

        // Interest 1
        JLabel firstInterest = new JLabel("Interest 1");
        firstInterest.setFont(FontManager.getCustomFont(14).deriveFont(Font.BOLD));
        constraints.insets = new Insets(topConstraint, 0, 0, 0);
        constraints.gridx = 1;
        mainPanel.add(firstInterest, constraints);

        constraints.insets = new Insets(topConstraint + 20, 0, 0, 0);
        JComboBox<String> firstComboBox = new JComboBox<>(interestArray);
        mainPanel.add(firstComboBox, constraints);
        interestComboBox.setSelectedItem(interestArray[0]);

        //interest 2
        JLabel secondInterest = new JLabel("Interest 2");
        secondInterest.setFont(FontManager.getCustomFont(14).deriveFont(Font.BOLD));
        constraints.insets = new Insets(topConstraint, 150, 0, 0);
        mainPanel.add(secondInterest, constraints);

        constraints.insets = new Insets(topConstraint + 20, 150, 0, 0);
        JComboBox<String> secondComboBox = new JComboBox<>(interestArray);
        mainPanel.add(secondComboBox, constraints);
        interestComboBox.setSelectedItem(interestArray[0]);

        //interest 3
        JLabel thirdInterest = new JLabel("Interest 3");
        thirdInterest.setFont(FontManager.getCustomFont(14).deriveFont(Font.BOLD));
        constraints.insets = new Insets(topConstraint, 300, 0, 0);
        mainPanel.add(thirdInterest, constraints);

        constraints.insets = new Insets(topConstraint + 20, 300, 0, 0);
        JComboBox<String> thirdComboBox = new JComboBox<>(interestArray);
        mainPanel.add(thirdComboBox, constraints);
        interestComboBox.setSelectedItem(interestArray[0]);

        return mainPanel;
    }

    private JTextField createEditableTextField(String text, String fieldValue, GridBagConstraints constraints, int width, int height) {
//        JPanel editableTextFieldPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints fieldConstraints = new GridBagConstraints();
//        fieldConstraints.gridx = 0;
//        fieldConstraints.gridy = 0;
//        fieldConstraints.insets = new Insets(0, 250, 5, 0); // Spacing between label and text field
//
//        // label
//        JLabel label = new JLabel(text);
//        label.setFont(FontManager.getCustomFont(14).deriveFont(Font.BOLD));
//        editableTextFieldPanel.add(label, fieldConstraints);

        // text field
        //constraints.gridy++;
        JTextField textField = new JTextField(); // width of box
        textField.setPreferredSize(new Dimension(width, height));
        textField.setText(fieldValue);
        textField.setFont(FontManager.getCustomFont(12));
//        editableTextFieldPanel.add(textField, fieldConstraints);

        return textField;
    }

    private void saveProfile() {
        // Get values from input fields and combos
        String firstName = userFname.getText().trim();
        String lastName = userLname.getText().trim();
        Integer year = (Integer) yearComboBox.getSelectedItem();
        String major = (String) majorComboBox.getSelectedItem();
        String bio = userBio.getText().trim();
        String interest1 = (String) interestComboBox.getSelectedItem();
        String interest2 = (String) interestComboBox.getSelectedItem();
        String interest3 = (String) interestComboBox.getSelectedItem();

        // Call the controller's method to validate and update the profile
        boolean isUpdated = editProfileController.validateAndUpdateProfile(firstName, lastName, user.getEmail(), year, major, bio, interest1, interest2, interest3);

        // Display success or error message
        if (isUpdated) {
            JOptionPane.showMessageDialog(this, "Profile updated successfully!");
            discoverController.goToDiscoverPage();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update profile. Please check your input.");
        }
    }
}

