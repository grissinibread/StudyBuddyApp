module com.studybuddy {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.studybuddy to javafx.fxml;
    opens com.studybuddy.controllers to javafx.fxml;
    exports com.studybuddy.controllers;
    exports com.studybuddy.models;
    exports com.studybuddy.views;
    exports com.studybuddy;
}