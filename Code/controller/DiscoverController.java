package controller;
import javax.swing.*;
import model.User;
import java.util.Vector;

public class DiscoverController {
    private User user = new User();
    //MATCHING ALGORITHM
    private void matchStudents(String major, int year, String interest1, String interest2, String interest3, int age) {
        /*OBJECTIVES: match based on...
         1) major 2) year 3) interests 4) age
         * ranked in order of importance */
        boolean majorMatch = false;
        boolean yearMatch = false;
        int yearDiff;
        int interestsMatch = 0;
        int ageDiff;
        Vector<User> matches = new Vector<>();

        if (user.getMajor() == major){
            majorMatch = true;
        }

        if (user.getYear() == year){
            yearMatch = true;
        } else {
            yearDiff = Math.abs(user.getYear() - year);
        }

        if (user.getInterest1() == interest1){
            interestsMatch++;
        }
        if (user.getInterest2() == interest2){
            interestsMatch++;
        }
        if (user.getInterest3() == interest3){
            interestsMatch++;
        }

        ageDiff = Math.abs(user.getAge() - age);

        // TODO: RANK MATCHES
//        if (majorMatch){
//
//        }

    }
}

// COMMENTING OUT TEMPORARILY TO TEST