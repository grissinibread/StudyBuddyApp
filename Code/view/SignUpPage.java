package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage extends JPanel {
    public SignUpPage() {
        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();

        //Title
        JLabel signUpLabel = new JLabel("Sign Up");
        signUpLabel.setFont(signUpLabel.getFont().deriveFont(Font.BOLD));
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        add(signUpLabel, frameConstraints);

        // First name
        JLabel firstName = new JLabel("First Name");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 1;
        add(firstName, frameConstraints);

        JTextArea firstNameField = new JTextArea();
        firstNameField.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 1;
        add(firstNameField, frameConstraints);
        /*TODO: CONNECT BACKEND WORK*/

        // Last Name
        JLabel lastName = new JLabel("Last Name");
        frameConstraints.gridx = 2;
        frameConstraints.gridy = 1;
        add(lastName, frameConstraints);

        JTextArea lastNameField = new JTextArea();
        lastNameField.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 3;
        frameConstraints.gridy = 1;
        add(lastNameField, frameConstraints);
        /*TODO: CONNECT BACKEND WORK*/

        // email
        JLabel email = new JLabel("Email");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 2;
        add(email, frameConstraints);

        JTextArea emailField = new JTextArea();
        emailField.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 2;
        add(emailField, frameConstraints);

        // password
        JLabel password = new JLabel("Password");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 3;
        add(password, frameConstraints);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 3;
        add(passwordField, frameConstraints);

        JLabel confirmPassword = new JLabel("Confirm Password");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 4;
        add(confirmPassword, frameConstraints);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 4;
        add(confirmPasswordField, frameConstraints);

        // Age
        JLabel age = new JLabel("Age");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 5;
        add(age, frameConstraints);

        JTextArea ageField = new JTextArea();
        ageField.setPreferredSize(new Dimension(200, 20));
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 5;
        add(ageField, frameConstraints);

        /*TODO: ASK ABOUT HOW TO IMPLEMENT AGE*/

        // major drop down menu
        JLabel major = new JLabel("Major");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 6;
        add(major, frameConstraints);

        JComboBox<String> majorComboBox = new JComboBox<String>(new String[]{"Computer Science", "Software Engineering"});
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 6;
        add(majorComboBox, frameConstraints);
        /*TODO: ADD ALL MAJORS THROUGH A LIST FROM CSUSM*/

        /*TODO: YEAR DROP DOWN*/
        JLabel graduationYear = new JLabel("Graduation Year");
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 7;
        add(graduationYear, frameConstraints);

        JComboBox<Integer> graduationYearComboBox = new JComboBox<Integer>(new Integer[]{2024, 2025});
        frameConstraints.gridx = 1;
        frameConstraints.gridy = 7;
        add(graduationYearComboBox, frameConstraints);

        //Makes and displays a Back to Login Button.
        JButton backToLoginButton = new JButton("Back to Login");
        frameConstraints.gridx = 3;
        frameConstraints.gridy = 8;
        add(backToLoginButton, frameConstraints);

        // Pressing the "Back to Login" button takes the user
        // back to the login screen.
        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage = new LoginPage();
                SignUpPage.this.removeAll();
                SignUpPage.this.add(loginPage);
                revalidate();
                repaint();
            }
        });
    }
}
