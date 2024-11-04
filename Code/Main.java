import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Create a JFrame instance
        JFrame frame = new JFrame("My Window");
        frame.setUndecorated(true); // removes the default title bar
        frame.setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints(); // Allows for placement of items on grid

        // Set the default close operation so the application exits when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the window size
        frame.setSize(800, 600);

        // Removes the title from the program
        frame.setTitle(null);

        // Setting a custom icon
        ImageIcon logo = new ImageIcon("C:\\Users\\alexn\\Downloads\\Study Buddy-20241103T185916Z-001\\Study Buddy\\src\\img\\logo.png");
        frame.setIconImage(logo.getImage());

        // Opens the application at the center of the screen
        frame.setLocationRelativeTo(null);

        // Create a label with the title text
        JLabel titleLabel = new JLabel("Study Buddy");

        // Set the font size and style for the title
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Font size 24 and bold style
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        // Add the label to the frame
        frame.add(titleLabel, frameConstraints);

        // Create and add text fields
        // Email input
        JTextArea emailTextBox = new JTextArea();
        emailTextBox.setPreferredSize(new Dimension(50, 10));
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Serif", Font.BOLD, 12));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 1;
        frame.add(emailLabel, frameConstraints);
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 2;
        frame.add(emailTextBox, frameConstraints);
        /*TODO: CONNECT BACKEND WORK*/

        // Password input
        JTextArea passwordTextBox = new JTextArea();
        passwordTextBox.setPreferredSize(new Dimension(50, 10));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 12));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 3;
        frame.add(passwordLabel, frameConstraints);
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 4;
        frame.add(passwordTextBox, frameConstraints);
        /*TODO: CONNECT BACKEND WORK*/

        // Login button
        JButton loginButton = new JButton("Login");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 5;
        frame.add(loginButton, frameConstraints);
        /*TODO: CONNECT BACKEND WORK OF LOGIN*/

        // Make the window visible
        frame.setVisible(true);
    }
}