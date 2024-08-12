package com.clubconnect;

public class staffpost {
    private String guest;
    private String numberStudents;
    private String eventDateTime;
    private String postDesc;
    private String imageUri; // You may add this field if you want to store the URI of the image

    // Constructor
    public staffpost(String guest, String numberStudents, String eventDateTime, String postDesc, String imageUri) {
        this.guest = guest;
        this.numberStudents = numberStudents;
        this.eventDateTime = eventDateTime;
        this.postDesc = postDesc;
        this.imageUri = imageUri;
    }

    // Getter methods
    public String getGuest() {
        return guest;
    }

    public String getNumberStudents() {
        return numberStudents;
    }

    public String getEventDateTime() {
        return eventDateTime;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public String getImageUri() {
        return imageUri;
    }
}
