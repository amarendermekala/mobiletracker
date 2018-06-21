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
    public Double getLocation1(@RequestParam("mobileNo") String mobileNo, @RequestParam("streetAddress") String streetAddress) {
        return 123.12;
    }
}
