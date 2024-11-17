package com.example.app.util;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FontManager {
    private static final Logger LOGGER = Logger.getLogger(FontManager.class.getName());
    private static Font customFont;

    static {
        try {
            // Loading custom font
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/fonts/FacultyGlyphic-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) {
            LOGGER.log(Level.SEVERE, "Failed to load custom font", e); // error handling
        }
    }

    public static Font getCustomFont(float size) {
        if (customFont != null) {
            return customFont.deriveFont(size); // Derive font with desired size
        }
        return new Font("Serif", Font.PLAIN, 12); // Fallback font
    }
}