package main.java.com.example.app;

import main.java.com.example.app.view.AppWindow;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/fonts/FacultyGlyphic-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

        } catch (IOException | FontFormatException _) {}

        AppWindow appWindow = new AppWindow();
        appWindow.setVisible(true); //Displays the window
    }
}