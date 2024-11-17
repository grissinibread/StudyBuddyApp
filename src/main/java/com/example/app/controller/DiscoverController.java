package com.example.app.controller;
import com.example.app.model.User;
import java.util.Vector;

public class DiscoverController {
    private User user1 = new User();
    private User user2 = new User();
    //MATCHING ALGORITHM
    public void matchStudents(User user1, User user2) {
        /*OBJECTIVES: match based on...
         1) major 2) year 3) interests 4) age
         * ranked in order of importance */
        boolean majorMatch = false;
        boolean yearMatch = false;
        int yearDiff;
        int interestsMatch = 0;
        int ageDiff;
        int commonalities = 0;
        Vector<User> matches = new Vector<>();

        if (user1.getMajor().equals(user2.getMajor())) {
            majorMatch = true;
        }

        if (user1.getYear() == user2.getYear()){
            yearMatch = true;
            commonalities++;
        } else {
            yearDiff = Math.abs(user1.getYear() - user2.getYear());
        }

        if (user1.getInterest1() == user2.getInterest1()){
            interestsMatch++;
            commonalities++;
        }
        if (user1.getInterest2() == user2.getInterest2()){
            interestsMatch++;
            commonalities++;
        }
        if (user1.getInterest3() == user2.getInterest3()){
            interestsMatch++;
            commonalities++;
        }

        ageDiff = Math.abs(user1.getAge() - user2.getAge()); // 0-2 yrs, 2+ yrs
        if (ageDiff <= 2){ commonalities++;}

        // TODO: RANK MATCHES
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
    }
}

