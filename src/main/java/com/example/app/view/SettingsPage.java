package com.example.app.view;

import javax.swing.*;
import java.awt.*;

public final class SettingsPage extends JPanel {
    //Initializes the one instance of a Settings Page to be used by the rest of the program.
    private static final SettingsPage settingsPage = new SettingsPage();

    //Settings Page constructor.
    private SettingsPage() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
    }

    //Returns the one instance of the settingsPage.
    public static SettingsPage getSettingsPage() {
        return settingsPage;
    }
}
