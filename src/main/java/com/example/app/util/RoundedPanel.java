package com.example.app.util;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {

    private final int cornerRadius;

    public RoundedPanel(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        setOpaque(false); // Allows the rounded corners to be visible
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set background color
        g2.setColor(getBackground());

        // Draw rounded rectangle
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
    }
}
