package com.studybuddy.models;

import com.studybuddy.views.viewFactory;

public class Model {
    private static Model model;
    private final viewFactory ViewFactory;
    private CurrentUser currentUser;

    private Model() {
        this.ViewFactory = new viewFactory();
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public viewFactory getViewFactory() {
        return ViewFactory;
    }

    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser; // Set the current user
    }
    public CurrentUser getCurrentUser() {
        if (currentUser == null)
            currentUser = new CurrentUser();
        return currentUser; // Retrieve the current user
    }
}