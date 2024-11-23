package com.example.app.view;

import javax.swing.*;
import java.awt.*;

public final class ProfilePage extends JPanel {
    //Initializes the one instance of a Profile Page to be used by the rest of the program.
    private static final ProfilePage profilePage = new ProfilePage();

    //Profile Page constructor.
    private ProfilePage() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //IDK
        add(addTitleLabel("Profile Name", constraints));
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
}