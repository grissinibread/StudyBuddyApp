package main.java.com.example.app;

import main.java.com.example.app.view.AppWindow;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AppWindow appWindow = new AppWindow();
        appWindow.setVisible(true); //Displays the window
    }
}