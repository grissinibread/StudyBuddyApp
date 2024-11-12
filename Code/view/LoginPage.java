package view;

import controller.SignUpController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JPanel {
    private SignUpController Lcontrol;
    public LoginPage() {
        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        // Create a label with the title text
        JLabel titleLabel = new JLabel("Study Buddy");

        // Set the font size and style for the title
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Font size 24 and bold style
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        // Add the label to the frame
        add(titleLabel, frameConstraints);

        JTextArea emailTextBox = new JTextArea();
        emailTextBox.setPreferredSize(new Dimension(200, 20));
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Serif", Font.BOLD, 12));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 1;
        add(emailLabel, frameConstraints);
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 2;
        add(emailTextBox, frameConstraints);
        /*TODO: CONNECT BACKEND WORK*/

        // Password input
        JTextArea passwordTextBox = new JTextArea();
        passwordTextBox.setPreferredSize(new Dimension(200, 20));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 12));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 3;
        add(passwordLabel, frameConstraints);
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 4;
        add(passwordTextBox, frameConstraints);
        /*TODO: CONNECT BACKEND WORK*/

        // Login button
        JButton loginButton = new JButton("Login");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 5;
        add(loginButton, frameConstraints);

        // Password Retrieval
        JButton forgotPasswordButton = new JButton("Forgot Password?");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 6;
        add(forgotPasswordButton, frameConstraints);
        /*TODO: CONNECT BACKEND WORK*/

        // SignUp Option
        JLabel signupLabel = new JLabel("Don't have an account?");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 7;
        add(signupLabel, frameConstraints);
        JButton signUprButton = new JButton("Sign Up");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 8;
        add(signUprButton, frameConstraints);

        // BACKEND CONNECTS: VERIFICATION OF EMAIL AND PASSWORD
        Lcontrol = new SignUpController(); // to be able to run functions connected to controller

        // Make the button do something
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attemptLogin(emailTextBox.getText(), passwordTextBox.getText());
            }
        });
    }

    public void attemptLogin(String email, String password) {
        boolean loginSuccess = Lcontrol.verifySignUp(email, password);
        if (loginSuccess) {
            /*TODO: NEXT PAGE CONTROL FUNCTION*/
            /*TODO: THIS SHOULD BE DONE IN THE APPWINDOW.JAVA FILE*/
            System.out.println("Login successful");
            //new DiscoverPage();
        } /*else {
            JOptionPane.showMessageDialog(null, "Sign Up Unsuccessful");
        }*/
    }
}
