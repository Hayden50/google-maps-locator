package com.groupsix.googlemapslocator.location;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class LocationController {

    private String apiKey = "AIzaSyBjZXpz2X3e0KhnzBK8Av7IDnbwfm0ZowU";

    @PostMapping("/api/locations")
    public List<String> postCoords(@RequestBody LocAddress loc) throws IOException {
        String latitude = loc.getLatitude();
        String longitude = loc.getLongitude();
        int max = 3;

        String strUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + latitude + "%2C"
                + longitude + "&radius=3000&type=restaurant&key=" + apiKey;
        URL url = new URL(strUrl);
        JsonNode json = get(url);
        List<String> list = new ArrayList<>();

        String status = json.get("status").asText();
        if (!status.equals("OK")) {
            list.add("There are no locations near these coordinates!");
            return list;
        }

        JsonNode results = json.get("results");
        for (int i = 0; i < max; i++) {
            list.add(results.get(i).get("name").asText());
            String locLat = results.get(i).get("geometry").get("location").get("lat").asText().substring(0, 5);
            String locLong = results.get(i).get("geometry").get("location").get("lng").asText().substring(0, 5);
            list.add(distance(latitude, longitude, locLat, locLong));
            list.add("--");
        }

        return list;
    }

    public static JsonNode get(URL url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(url);
    }

    public static String distance(String startLat, String startLong, String endLat, String endLong) {

        double lat1 = Math.toRadians(Double.parseDouble(startLat));
        double lon1 = Math.toRadians(Double.parseDouble(startLong));
        double lat2 = Math.toRadians(Double.parseDouble(endLat));
        double lon2 = Math.toRadians(Double.parseDouble(endLong));

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                        * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;

        return String.valueOf(c * r);
    }
}
