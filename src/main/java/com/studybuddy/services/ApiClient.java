package com.studybuddy.services;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClient {
    public static void signUp_User(String firstName, String lastName, String email, String password) {
        try {
            URL url = new URL("http://localhost:8080/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Create JSON object for user data
            String jsonInputString = String.format(
                    "{\"firstName\": \"%s\", \"lastName\": \"%s\", \"email\": \"%s\", \"password\": \"%s\"}",
                    firstName, lastName, email, password
            );

            // Write JSON data to request body
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Check response code
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("User signed up successfully.");
            } else {
                System.out.println("Failed to sign up user. Response code: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}