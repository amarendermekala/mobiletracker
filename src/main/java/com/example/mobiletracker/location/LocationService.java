package com.example.mobiletracker.location;

import com.example.mobiletracker.entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationService implements ILocationService {

    @Autowired
    LocationRepository iLocationRepository;

    @Override
    public Location getLocationByMobileNumber(String mobileNo) {
        return iLocationRepository.getLocationByMobileNumber(mobileNo);
    }
}
