package com.example.app.view;

import javax.swing.*;
import java.awt.*;

public final class InboxPage extends JPanel {
    //Initializes the one instance of an Inbox Page to be used by the rest of the program.
    private static final InboxPage inboxPage = new InboxPage();

    //Profile Page constructor.
    private InboxPage() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //IDK
        add(addTitleLabel("This is the inbox page.", constraints));
    }

    //Returns the one instance of the inboxPage.
    public static InboxPage getInboxPage() {
        return inboxPage;
    }

    // TODO: Setup Inbox Page entirely. Anything below this can be deleted when doing the TODO.
    private JLabel addTitleLabel(String text, GridBagConstraints constraints) {
        JLabel label = new JLabel();
        label.setText(text);
        add(label, constraints);
        return label;
    }
}
