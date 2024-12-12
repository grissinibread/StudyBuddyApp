package com.example.app.model;

import java.util.List;

public class User {
    private String name;
    private String fname;
    private String lname;
    private Integer age;
    private String major;
    private Integer year;
    private String bio;
    private String[] interests;
    private String interest1;
    private String interest2;
    private String interest3;
    private String email;
    private String password;

    private static User currentUser;

    public User (){
//        this.name = "";
//        this.age = 0;
//        this.major = "";
//        this.year = 0;
//        this.interests = new String[0];
//        this.email = "";
//        this.password = "";
        this.bio = "Tell us about yourself here!";
        this.interest1 = "Select Interest";
        this.interest2 = "Select Interest";
        this.interest3 = "Select Interest";
    }

    public User(String email, String password, String fname, String lname, Integer age, String major, Integer year, String bio, String interest1, String interest2, String interest3) {
        this.name = fname + " " + lname;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.age = age;
        this.major = major;
        this.year = year;
        this.bio = bio;
        this.interest1 = interest1;
        this.interest2 = interest2;
        this.interest3 = interest3;
    }

    public User(String fname, Integer age, String major, Integer year, String i1, String i2, String i3) { // for matching comparisons, so password of other users isn't shown
        this.fname = fname;
        this.age = age;
        this.major = major;
        this.year = year;
        this.interest1 = i1;
        this.interest2 = i2;
        this.interest3 = i3;
    }

    //public static void setUser(User user) {currentUser = user;}

    public static User getUser() {
        if (currentUser == null) {
            currentUser = new User();
        }
        return currentUser;
    }

    // GETTERS AND SETTERS
    // name functions
    public String getName() {
        return name;
    }
    //Full name for display, ex. "John Doe"
    public void setName(String first, String last) { this.name = first + " " + last; }
    //First & Last name separated
    public void setFName(String firstName) { this.fname = firstName; }
    public void setLName(String lastName) {this.lname = lastName;}
    public String getFName() { return fname; }
    public String getLName() { return lname; }
    // age functions
    public Integer getAge() {
        return age;
    }
    public void setAge(int age) {this.age = age;}
    // major functions
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {this.major = major;}
    // year functions
    public Integer getYear() {
        return year;
    }
    public void setYear(int year) {this.year = year;}
    //bio functions
    public void setBio(String bio) { this.bio = bio;}
    public String getBio() {return bio;}

    //interestts functions
    public String[] getInterests(){
        interests = new String[3];
        interests[0] = interest1;
        interests[1] = interest2;
        interests[2] = interest3;
        return interests;
    }
    public String getInterest1() { return interest1; }
    public void setInterest1(String interest1) { this.interest1 = interest1; }
    public String getInterest2() { return interest2; }
    public void setInterest2(String interest2) { this.interest2 = interest2; }
    public String getInterest3() { return interest3; }
    public void setInterest3(String interest3) { this.interest3 = interest3; }

    // interest functions
//    public String getInterests() {
//        return interests[0] + ", " + interests[1] + ", " + interests[2];
//    }
//
//    public String getInterest(int pos) {
//        return interests[pos];
//    }
//
//    public void setInterests(String interest1, String interest2, String interest3) {
//        this.interests[0] = interest1;
//        this.interests[1] = interest2;
//        this.interests[2] = interest3;
//    }
    // email functions
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    // password functions
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    // database function
    public void storeUser() {
    }


}
