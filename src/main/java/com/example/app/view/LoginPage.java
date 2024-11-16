package main.java.com.example.app.view;

import main.java.com.example.app.controller.SignUpController;
import main.java.com.example.app.util.FontManager;
// import view.appW; //this too did nothing for me
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JPanel {
    private SignUpController Lcontrol;
    //public boolean loginApproved = false;
    // private appW; // I was trying to direct it using this class but it wouldn't let me :,) cry

    // background color gradient
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Define the gradient
        int width = getWidth();
        int height = getHeight();
        Color color1 = Color.decode("#87CEFA"); // light blue
        Color color2 = Color.decode("#FFFFFF"); // white
        GradientPaint gradient = new GradientPaint(0, 0, color1, width, height, color2);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }

    public LoginPage() {
//        // colors
//        Color buttons1 = Color.decode("#008080"); // teal
//        Color buttons2 = Color.decode("##FF8C42"); // orange
//        Color input = Color.decode("#F0F0F0"); // light grey

        // setBackground(Color.decode("#ADD8E6"));
        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        // Create a label with the title text
        JLabel titleLabel = new JLabel("Study Buddy");
        titleLabel.setFont(FontManager.getCustomFont(50).deriveFont(Font.BOLD));
        titleLabel.setForeground(Color.decode("#000000"));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        frameConstraints.insets = new Insets(0, 0, 25, 0);
        add(titleLabel, frameConstraints);

        // email section
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(FontManager.getCustomFont(16));
        emailLabel.setForeground(Color.decode("#4A4A4A"));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 1;
        frameConstraints.insets = new Insets(0, 0, 0, 0);
        add(emailLabel, frameConstraints);

        JTextArea emailTextBox = new JTextArea();
        emailTextBox.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 2;
        add(emailTextBox, frameConstraints);

        // Password section
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(FontManager.getCustomFont(16));
        passwordLabel.setForeground(Color.decode("#4A4A4A"));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 3;
        add(passwordLabel, frameConstraints);

        JTextArea passwordTextBox = new JTextArea();
        passwordTextBox.setPreferredSize(new Dimension(200, 20));
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

        // When Sign Up Button is pressed, it takes you to the Sign Up Page.
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpPage signUpPage = new SignUpPage();
                LoginPage.this.removeAll();
                LoginPage.this.add(signUpPage);
                revalidate();
                repaint();
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
