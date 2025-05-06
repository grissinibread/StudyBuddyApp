package com.studybuddy.controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class userCardController {
    public void setUserCard_GraduationYear(Text userCard_GraduationYear) {
        this.userCard_GraduationYear = userCard_GraduationYear;
    }

    public void setUserCard_Major(Text userCard_Major) {
        this.userCard_Major = userCard_Major;
    }

    public void setUserInterest1(Text userInterest1) {
        this.userInterest1 = userInterest1;
    }

    public void setUserInterest2(Text userInterest2) {
        this.userInterest2 = userInterest2;
    }

    public void setUserInterest3(Text userInterest3) {
        this.userInterest3 = userInterest3;
    }

    public void setUserName(Text userName) {
        this.userName = userName;
    }
    @FXML
    public Text userCard_GraduationYear;
    public Text userCard_Major;
    public Text userInterest1;
    public Text userInterest2;
    public Text userInterest3;
    public Text userName;



}
