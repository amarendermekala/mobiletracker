package com.example.mobiletracker.location;

import com.example.mobiletracker.entities.Location;
import com.example.mobiletracker.utils.GeoCoderUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LocationRepository {
    private static Map<String, Location> phoneNumberToLocationMap;

    static {
        phoneNumberToLocationMap = new HashMap<>();
        phoneNumberToLocationMap.put("123", new Location(33.008080, -96.751585, "AT&T Plano Address"));
        phoneNumberToLocationMap.put("234", new Location(32.779561, -96.798889, "AT&T Dallas Address"));
    }

    public Location getLocationByMobileNumber(String mobileNo) {
        Location location = phoneNumberToLocationMap.get(mobileNo);
        if(location == null) {
            return new Location(11.11, 11.11, "Dummy Address");
        }
        try {
            String address = GeoCoderUtils.getAddressByGpsCoordinates(Double.toString(location.getLatitude()), Double.toString(location.getLongitude()));
            location.setStreetAddress(address);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return location;
    }
}
