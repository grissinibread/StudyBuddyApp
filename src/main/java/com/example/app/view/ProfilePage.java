package com.example.app.view;

import javax.swing.*;
import java.awt.*;

public class ProfilePage extends JPanel {
    public ProfilePage() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //
        add(addTitleLabel("Profile Name", constraints));
    }
    
    private JLabel addTitleLabel(String text, GridBagConstraints constraints) {
        JLabel label = new JLabel();
        label.setText(text); // TODO: CONNECT ACTUAL NAME FROM DATABASE
        add(label, constraints);
        return label;
    }
    
}