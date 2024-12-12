package com.example.app.controller;
import com.example.app.model.User;
import com.example.app.view.AppWindow;
import com.example.app.view.DiscoverPage;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;

// mongoDB packages
import com.mongodb.client.MongoDatabase;
import com.example.app.util.MongoDBConnector;

public class DiscoverController {
    private final MongoDatabase database;
    private final User mainUser;
    public DiscoverController() {
        this.database = MongoDBConnector.getDatabase();
        this.mainUser = UserSession.getLoggedInUser();
    }
    //MATCHING ALGORITHM
    private int matchRank(User user1, User user2) {
        /*OBJECTIVES: match based on...
         1) major 2) year 3) interests 4) age
         * ranked in order of importance */
        boolean majorMatch = false;
        boolean yearMatch = false;
        int interestsMatch = 0;
        int ageDiff;
        int commonalities = 0;
        //Vector<User> matches = new Vector<>();

        if (user1.getMajor().equals(user2.getMajor())) {
            majorMatch = true;
        }

        if (user1.getYear() == user2.getYear()){
            yearMatch = true;
            commonalities++;
        }
        if (user1.getInterest1().equals(user2.getInterest1()) || user1.getInterest1().equals(user2.getInterest2()) || user1.getInterest1().equals(user2.getInterest3())) {
            interestsMatch++;
            commonalities++;
        }
        if (user1.getInterest2().equals(user2.getInterest1()) || user1.getInterest2().equals(user2.getInterest2()) || user1.getInterest2().equals(user2.getInterest3())) {
            interestsMatch++;
            commonalities++;
        }
        if (user1.getInterest3().equals(user2.getInterest1()) || user1.getInterest3().equals(user2.getInterest2()) || user1.getInterest3().equals(user2.getInterest3())) {
            interestsMatch++;
            commonalities++;
        }

//        for (int i = 0; i<3; i++){
//            for( int j=0; j<3; j++){
//                if (user1.getInterest(i).equals(user2.getInterest(j))){
//                    interestsMatch++;
//                    commonalities++;
//                    break;
//                }
//            }
//        }

        ageDiff = Math.abs(user1.getAge() - user2.getAge()); // 0-2 yrs, 2+ yrs
        if (ageDiff <= 2){ commonalities++;}

        // if major matches, at least 2 other aspects must match
        // if major does not match 3 others ( year + 2 more)
        int rank = 0; // all aspects match
        if (majorMatch && commonalities >= 2){ // same major + ... (at least 2 more)
            if (yearMatch){ // same year + ...
                if(interestsMatch == 3 && ageDiff > 2){ // 3 interests
                    rank++; // rank 1
                }
                if (interestsMatch == 2){ // 2 interests
                    rank += 2; // at least rank 2 (& age)
                    if (ageDiff > 2){
                        rank++; // rank 3 (not age)
                    }
                }
                if (interestsMatch == 1){ // 1 interest
                    rank += 4; // at least rank 4 (& age)
                    if (ageDiff > 2){
                        rank++; // rank 5 (not age)
                    }
                }
            }
            else { // major + NOT year + ...
                rank = 7; // highest rank can be 7 ( ... + 3 interest + age)
                if(interestsMatch == 3 && ageDiff > 2){ // 3 interests
                    rank++; // rank 8
                }
                if (interestsMatch == 2){ // 2 interests
                    rank += 2; // at least rank 9 (& age)
                    if (ageDiff > 2){
                        rank++; // rank 10 (not age)
                    }
                }
                if (interestsMatch == 1){ // 1 interest
                    rank += 4; // rank 11 (& age)
                }
            }
        }
        else if (!majorMatch && yearMatch && (commonalities -1) >= 2) { // major does NOT match
            rank = 12;
            if (interestsMatch == 3 && ageDiff > 2){
                rank++;
            }
            if (interestsMatch == 2){ // 2 interests
                rank += 2; // at least rank 14 (& age)
                if (ageDiff > 2){
                    rank++; // rank 15 (not age)
                }
            }
            if (interestsMatch == 1){ // 1 interest
                rank += 4; // at least rank 16 (& age)
            }
        }
        else { rank = -1; } // not an acceptable match
        System.out.println("Rank: " + rank);
        return rank;
    }

    //Takes the user to the Discover Page.
    public void goToDiscoverPage(){
        //AppWindow.getAppWindow().openPage(AppWindow.getAppWindow().getDiscoverPage());
        AppWindow.getAppWindow().openPage(DiscoverPage.getDiscoverPage());
    }

    public ArrayList<User> getMatches(){
        MongoCollection<Document> usersCollection = database.getCollection("StudyBuddy2.0"); // grabs the entirety of the users database
        ArrayList<User> matches = new ArrayList<>();

        try(MongoCursor<Document> cursor = usersCollection.find().iterator()){ // cursor to go through all the users
            while (cursor.hasNext()){
                Document otherUsers = cursor.next();
                if(otherUsers.getString("email").equals(mainUser.getEmail())){
                    continue; // skip mainUser
                }
                User userCompared = new User(
                        otherUsers.getString("name"), otherUsers.getInteger("age"),
                        otherUsers.getString("major"), otherUsers.getInteger("year")
                );
                int rank = matchRank(mainUser, userCompared);
                if (rank > 0){
                    matches.add(userCompared);
                    bubbleUp(matches, mainUser);
                }
            }
        }

        return matches;
    }

    // sort match array to make the most similar matches be stored first
    private void bubbleUp (ArrayList<User> matches, User user){
        int i = matches.size() - 1;
        while (i > 0){
            User current = matches.get(i);
            User previous = matches.get(i - 1);

            if (matchRank(user, current) < matchRank(user, previous)){
                // swap if the current user has a smaller rank than the previous
                matches.set(i - 1, current);
                matches.set(i, previous);
            } else {break;} // stop if order correct
            i--;
        }
    }

}