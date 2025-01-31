module com.studybuddy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.studybuddy to javafx.fxml;
    exports com.studybuddy.controllers;
    exports com.studybuddy.models;
    exports com.studybuddy.views;
    exports com.studybuddy;
}