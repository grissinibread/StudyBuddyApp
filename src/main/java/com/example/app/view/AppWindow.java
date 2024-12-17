package com.example.app.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

public final class AppWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Layout Manager
        StackPane root = new StackPane();

        // Sets the default application size
        primaryStage.setScene(new Scene(root, 400, 300));

        // Displays the application
        primaryStage.show();
    }
}
    //Returns the one instance of the AppWindow.
    // public static AppWindow getAppWindow() {
        //return appWindow;
    // }

//    // Open a specific page inside the window
//    public void openPage(JPanel page) {
//        setContentPane(page);
//        revalidate();
//        repaint();
//    }
//}
