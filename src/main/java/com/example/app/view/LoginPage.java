package main.java.com.example.app.view;

import main.java.com.example.app.controller.SignUpController;
// import view.appW; //this too did nothing for me
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JPanel {
    private SignUpController Lcontrol;
    //public boolean loginApproved = false;
    // private appW; // I was trying to direct it using this class but it wouldn't let me :,) cry
    public LoginPage() {
        setBackground(Color.decode("#4A90E2"));
        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        // Create a label with the title text
        JLabel titleLabel = new JLabel("Study Buddy");

        // Set the font size and style for the title
        titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 24)); // Font size 24 and bold style
        titleLabel.setForeground(Color.decode("#4A4A4A"));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        // Add the label to the frame
        add(titleLabel, frameConstraints);

        JTextArea emailTextBox = new JTextArea();
        emailTextBox.setPreferredSize(new Dimension(200, 20));
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Comic Sans", Font.BOLD, 12));
        emailLabel.setForeground(Color.decode("#4A4A4A"));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 1;
        add(emailLabel, frameConstraints);
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 2;
        add(emailTextBox, frameConstraints);

        // Password input
        JTextArea passwordTextBox = new JTextArea();
        passwordTextBox.setPreferredSize(new Dimension(200, 20));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 12));
        passwordLabel.setForeground(Color.decode("#4A4A4A"));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 3;
        add(passwordLabel, frameConstraints);
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 4;
        add(passwordTextBox, frameConstraints);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Serif", Font.BOLD, 12));
        loginButton.setForeground(Color.decode("#4A4A4A"));
        loginButton.setBackground(Color.decode("#F8E71C"));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 5;
        frameConstraints.insets = new Insets(10, 0, 0, 0);
        add(loginButton, frameConstraints);

        // Password Retrieval
        JButton forgotPasswordButton = new JButton("Forgot Password?");
        forgotPasswordButton.setBorderPainted(false);
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 6;
        add(forgotPasswordButton, frameConstraints);
        /*TODO: CONNECT BACKEND WORK*/

        // SignUp Option
        JLabel signupLabel = new JLabel("Don't have an account?");
        signupLabel.setFont(new Font("Serif", Font.BOLD, 12));
        signupLabel.setForeground(Color.decode("#4A4A4A"));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 7;
        add(signupLabel, frameConstraints);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(Color.decode("#F8E71C"));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 8;
        add(signUpButton, frameConstraints);

        // BACKEND CONNECTS: VERIFICATION OF EMAIL AND PASSWORD
        Lcontrol = new SignUpController(); // to be able to run functions connected to controller

        // Make the button do something
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //loginApproved = Lcontrol.verifySignUp(emailTextBox.getText(), passwordTextBox.getText());
                if (Lcontrol.verifySignUp(emailTextBox.getText(), passwordTextBox.getText())) {
                    //appW.openPage(new DiscoverPage());
                }
            }
        });
    }

//    public boolean attemptLogin(String email, String password) {
//        boolean loginSuccess = Lcontrol.verifySignUp(email, password);
//        if (loginSuccess) {
//            /*TODO: NEXT PAGE CONTROL FUNCTION*/
//            /*TODO: THIS SHOULD BE DONE IN THE APPWINDOW.JAVA FILE*/
//            System.out.println("Login successful");
//            return true;
//        }
//        return false;
//    }
}
