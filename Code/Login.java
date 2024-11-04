import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
public class Login extends JFrame /*implements ActionListener*/{
    JButton loginbutton;
    JPanel newPanel;
    JLabel email, password;

    Login(){ // constructor
//        EMAIL LABELS
        // setting label for email
       email = new JLabel();
       email.setText("School Email"); // set label for emailtext

        // text field to get email from user
        JTextField emailtext = new JTextField();
//        END OF EMAIL LABELS

//        PASSWORD LABELS
        password = new JLabel();
        password.setText("Password"); // set label for passwordtext
        JTextField passwordtext = new JTextField();
//        END OF PASSWORD LABELS

        loginbutton = new JButton("LOGIN"); // label for button to submit information and login

        // PANEL FOR ALL ELEMENTS
        newPanel = new JPanel(new GridLayout(3,1));
        newPanel.add(email); // email label in panel
        newPanel.add(emailtext); // text to enter email in panel
        newPanel.add(password); // password label in panel
        newPanel.add(passwordtext); // text to enter pass in panel
        newPanel.add(loginbutton); // login button in panel

        // border for panel
        add(newPanel, BorderLayout.CENTER);

        // make button clickable
        //loginbutton.addActionListener(this);
        setTitle("Login");
    }

    // when button is clicked
    public void clicking(ActionEvent e){
        String emailVal = email.getText();  // get email entered by user
        String passwordVal = password.getText(); // get pass entered by user
    }

    // checks validity of email
    private boolean emailValid(String email){
        int i = email.indexOf("@"); // finds @ in email
        int j = email.indexOf("."); // finds . in email
        // TO DO: MAKE SURE ALL OF THE CHARACTERS ARE LETTERS
        String end = email.substring(i+1); // string after @
        if (i == -1 || j == -1){ // missing @ or . means not valid
            return false;
        }
        if (end != "csusm.edu"){ // not csusm email means not valid
            return false;
        }
        return true;
    }

    // checks validity of password
    private boolean passwordValid(String password){
        return true;
    }

}