package com.example.mobiletracker.entities;

import java.time.Instant;

public class RelativeLocation extends Location {

    public RelativeLocation(double lat, double longi, String streetAddress) {
        super(lat, longi, streetAddress);
    }

    private Instant timeStamp;

}
