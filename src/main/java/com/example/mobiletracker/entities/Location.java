package com.example.mobiletracker.entities;

public class Location {
    private double latitude;
    private double longitude;
    private String streetAddress;

    public Location(double latitude, double longitude, String streetAddress) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.streetAddress = streetAddress;
    }

    public double getLatitude() {

        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
}
