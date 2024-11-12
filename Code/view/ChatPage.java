package view;

import javax.swing.*;
import java.awt.*;

public class ChatPage extends JPanel {
    public ChatPage() {
        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        // Temporary Message Label
        JLabel chatLabel = new JLabel("Chat");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        add(chatLabel, frameConstraints);

        // Message Input
        JTextArea chatTextArea = new JTextArea();
        chatTextArea.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 1;
        add(chatTextArea, frameConstraints);

        // Send button
        JButton sendButton = new JButton("Send");
        frameConstraints.gridx = 2;
        frameConstraints.gridy = 1;
        add(sendButton, frameConstraints);
        /*TODO: BACKEND WORK*/
    }
}
