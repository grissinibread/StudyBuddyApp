package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DiscoverPage extends JPanel {
    public DiscoverPage() throws IOException {
        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        // Create a label with the title text
        JLabel titleLabel = new JLabel("Discover");

        // Set the font size and style for the title
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Font size 24 and bold style
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        // Add the label to the frame
        add(titleLabel, frameConstraints);

        ImageIcon image = new ImageIcon("code/view/img/settings.png");
        JLabel settings = new JLabel(image);
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 0;
        add(settings, frameConstraints);
    }
}
