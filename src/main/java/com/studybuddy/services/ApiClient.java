package com.studybuddy.services;

import com.studybuddy.models.CurrentUser;
import com.studybuddy.models.Match;
import com.studybuddy.models.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.studybuddy.models.User;

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
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
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

    public static boolean logIn_User(String email, String password) {
        try {
            URL url = new URL("http://localhost:8080/users/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Create JSON object for user data
            String jsonInputString = String.format(
                    "{\"email\": \"%s\", \"password\": \"%s\"}",
                    email, password
            );

            // Write JSON data to request body
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Check response code
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Parse the response to extract the user ID
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper mapper = new ObjectMapper();
                JsonNode responseJson = mapper.readTree(response.toString());
                String userId = responseJson.get("id").asText();

                // Fetch user data using the extracted user ID
                fetchUserData(userId);
                // Set the email in the CurrentUser instance
                CurrentUser currentUser = Model.getInstance().getCurrentUser();
                if (currentUser != null) {
                    currentUser.setEmail(email);
                }

                System.out.println("User logged in successfully.");
                return true;
            } else if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                System.out.println("User does not exist.");
            } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                System.out.println("Invalid password.");
            } else {
                System.out.println("Login failed. Response code: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void fetchUserData(String userId) {
        try {
            URL url = new URL("http://localhost:8080/users/" + userId + "/myInfo");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // Check response code
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Parse the response to populate CurrentUser
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper mapper = new ObjectMapper();
                CurrentUser currentUser = mapper.readValue(response.toString(), CurrentUser.class);

                // Save the populated CurrentUser instance
                Model.getInstance().setCurrentUser(currentUser);

                System.out.println("User data retrieved and set successfully.");
            } else {
                System.out.println("Failed to fetch user data. Response code: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> retreiveAllUsers() {
        var users = new ArrayList<User>();

        try {
            URL url = new URL("http://localhost:8080/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // Check response code
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Parse the response to populate CurrentUser
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper mapper = new ObjectMapper();
                for (JsonNode userNode : mapper.readTree(response.toString())) {
                    User user = mapper.treeToValue(userNode, User.class);
                    users.add(user);

                    System.out.printf("ID: %s, Name: %s %s, Email: %s, Age: %d, Major: %s, Grad Year: %d, Interests: %s, Bio: %s%n",
                            user.getId(),
                            user.getFirstName(),
                            user.getLastName(),
                            user.getEmail(),
                            user.getAge(),
                            user.getMajor(),
                            user.getGradYear(),
                            user.getInterests(),
                            user.getBio()
                    );
                }

                System.out.println("User data retrieved and set successfully.");
            } else {
                System.out.println("Failed to fetch user data. Response code: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static List<Match> retreiveAllMatches() {
        var matches = new ArrayList<Match>();
        String currentUserId = Model.getInstance().getCurrentUser().getId();
        System.out.println("Current user ID in API call: " + currentUserId);
        try {
            URL url = new URL("http://localhost:8080/users/matches/" + currentUserId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper mapper = new ObjectMapper();
                for (JsonNode node : mapper.readTree(response.toString())) {
                    Match match = mapper.treeToValue(node, Match.class);
                    matches.add(match);
                }
            } else {
                System.out.println("Failed to get matches. Response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matches;
    }
}