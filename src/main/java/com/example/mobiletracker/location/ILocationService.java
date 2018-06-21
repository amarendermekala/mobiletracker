package com.example.mobiletracker.location;

import com.example.mobiletracker.entities.Location;

public interface ILocationService {

    public Location getLocationByMobileNumber(String mobileNo);
}
