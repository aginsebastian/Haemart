package com.example.haemart;

public class ThreadModel {

    private  int image;
    private String name,venue,date;

    public ThreadModel(int image, String name, String venue, String date) {
        this.image = image;
        this.name = name;
        this.venue = venue;
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
