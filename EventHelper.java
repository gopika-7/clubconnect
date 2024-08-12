package com.clubconnect;

public class EventHelper {
    private final String eventName;
    private final String eventDate;
    private final String eventLocation;
    private final String eventDescription;
    private String id;

    // Constructor


    public EventHelper(String eventName, String eventDate, String eventLocation, String eventDescription) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
    }

    // Getter methods

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getId() {
        return id;
    }

    // Method to get the image URL for the event
    public String getImageUrlForEvent(String id) {
        // Logic to retrieve the image URL for the event based on its ID
        // This method should be implemented based on how you store and retrieve event images
        return "https://console.firebase.google.com/project/clubconnect-b93d3/database/clubconnect-b93d3-default-rtdb/data/~2F"; // Return the image URL or an empty string if not implemented
    }

    public void setEventName(String eventName) {
    }

    public void setEventDateTime(String eventDateTime) {
    }

    public void setEventLocation(String eventLocation) {
    }

    public void setEventDescription(String eventDescription) {
    }
}
