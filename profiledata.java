package com.clubconnect;

public class profiledata {
    private String name;
    private String rollNo;
    private String clubCategory;
    private String email;

    public profiledata() {
        // Default constructor required for Firebase
    }

    public profiledata(String name, String rollNo, String clubCategory, String email) {
        this.name = name;
        this.rollNo = rollNo;
        this.clubCategory = clubCategory;
        this.email = email;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getClubCategory() {
        return clubCategory;
    }

    public void setClubCategory(String clubCategory) {
        this.clubCategory = clubCategory;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
