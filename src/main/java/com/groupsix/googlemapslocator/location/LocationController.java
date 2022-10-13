package com.groupsix.googlemapslocator.location;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @PostMapping("/api/locations")
    public String postCoords(@RequestBody Location loc) {
        return "Success!";
    }
}
