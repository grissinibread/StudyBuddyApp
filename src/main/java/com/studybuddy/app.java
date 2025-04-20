package com.studybuddy;

import com.studybuddy.models.Model;
import javafx.application.Application;
import javafx.stage.Stage;


public class app extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // TODO: Fix Structure
        Model.getInstance().getViewFactory().showLogin();
    }
}