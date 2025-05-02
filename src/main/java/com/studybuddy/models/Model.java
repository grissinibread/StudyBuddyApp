package com.studybuddy.models;

import com.studybuddy.views.viewFactory;

public class Model {
    private static Model model;
    private final viewFactory ViewFactory;

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
}