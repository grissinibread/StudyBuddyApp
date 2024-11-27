package com.example.app.model;

import javax.swing.*;

public class User {
    private String name;
    private int age;
    private String major;
    private int year;
    private String[] interests;
//    private String interest2;
//    private String interest3;
    private String email;
    private String password;

    public User (){
        this.name = "";
        this.age = 0;
        this.major = "";
        this.year = 0;
        this.interests = new String[0];
//        this.interest2 = "";
//        this.interest3 = "";
        this.email = "";
        this.password = "";
    }

    public User(String name, int age, String major, int year, String interest1, String interest2, String interest3) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.year = year;
        this.interests = new String[]{interest1, interest2, interest3};
//        this.interest2 = interest2;
//        this.interest3 = interest3;
    }

    // name functions
    public String getName() {
        return name;
    }
    public void setName(String first, String last) { this.name = first + " " + last; }
    // age functions
    public int getAge() {
        return age;
    }
    public void setAge(int age) {this.age = age;}
    // major functions
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {this.major = major;}
    // year functions
    public int getYear() {
        return year;
    }
    public void setYear(int year) {this.year = year;}
    // interest functions
    public String getInterests() {
        return interests[0] + ", " + interests[1] + ", " + interests[2];
    }

    public String getInterest(int pos) {
        return interests[pos];
    }
//    public String getInterest2() {
//        return interest2;
//    }
//    public String getInterest3() {
//        return interest3;
//    }
    public void setInterests(String interest1, String interest2, String interest3) {
        this.interests[0] = interest1;
        this.interests[1] = interest2;
        this.interests[2] = interest3;
    }
    // email functions
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    // password functions
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
