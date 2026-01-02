package com.model;

public class Restaurant {

    private int id;
    private String name;
    private String cuisine;
    private String location;
    private double rating;
    private int eta;
    private String image;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCuisine() { return cuisine; }
    public void setCuisine(String cuisine) { this.cuisine = cuisine; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public int getEta() { return eta; }
    public void setEta(int eta) { this.eta = eta; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}

