package com.example.mobiletracker.location;

import com.example.mobiletracker.entities.Location;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tracker")
public class LocationController {

    @Autowired
    ILocationService iLocationService;

    @ApiOperation(value = "Get phone location details using the phone number",response = Location.class)
    @RequestMapping(method = RequestMethod.GET, value = "/{mobileNo}")
    public Location getLocation(@PathVariable("mobileNo") String mobileNo) {
        return iLocationService.getLocationByMobileNumber(mobileNo);
    }

    @ApiOperation(value = "Get distance between the mobile location and the specified location in miles",response = Double.class)
    @RequestMapping(method = RequestMethod.GET, value = "/distance")
    public Double getDistance(@RequestParam("mobileNo") String mobileNo, @RequestParam("streetAddress") String streetAddress) {
        return 123.12;
    }

//    @ApiOperation(value = "Get distance between the mobile location and the specified location in miles",response = Double.class)
//    @RequestMapping(method = RequestMethod.GET, value = "/distance")
//    public String getRelativeDistanceDetails(@RequestParam("mobileNo") String mobileNo, @RequestParam("storeAddress") String storeAddress) {
//        return "https://maps.googleapis.com/maps/api/staticmap?size=500x500&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Clabel:C%7C40.718217,-73.998284";
//    }
}
