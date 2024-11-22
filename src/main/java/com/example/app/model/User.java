package com.example.app.model;

public class User {
    private String name;
    private int age;
    private String major;
    private int year;
    private String interest1;
    private String interest2;
    private String interest3;

    public User (){
        this.name = "";
        this.age = 0;
        this.major = "";
        this.year = 0;
        this.interest1 = "";
        this.interest2 = "";
        this.interest3 = "";
    }

    public User(String name, int age, String major, int year, String interest1, String interest2, String interest3) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.year = year;
        this.interest1 = interest1;
        this.interest2 = interest2;
        this.interest3 = interest3;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getMajor() {
        return major;
    }
    public int getYear() {
        return year;
    }
    public String getInterest1() {
        return interest1;
    }
    public String getInterest2() {
        return interest2;
    }
    public String getInterest3() {
        return interest3;
    }
}
