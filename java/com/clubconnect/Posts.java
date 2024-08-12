package com.clubconnect;

public class Posts {
    private String clubName;
    private String postDesc;

    // Required default constructor for Firebase
    public Posts() {
    }

    public Posts(String clubName, String postDesc) {
        this.clubName = clubName;
        this.postDesc = postDesc;
    }



    public Posts(String guest, String numberStudent, String postDescription) {
    }

    // Getters and setters
    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }
}

