package com.groupsix.googlemapslocator.location;

import java.io.*;
import java.net.URL;
import java.util.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class LocationController {

    private String apiKey = "AIzaSyBjZXpz2X3e0KhnzBK8Av7IDnbwfm0ZowU";

    public static final Map<String, String> staticMap = new HashMap<>();

    static {
        staticMap.put("point_of_interest", "Point of Interest");
        staticMap.put("locality", "Locality");
        staticMap.put("school", "School");
        staticMap.put("local_government_office", "Government Office");
        staticMap.put("library", "Library");
        staticMap.put("liquor_store", "Liquor Store");
        staticMap.put("store", "Store");
        staticMap.put("fire_station", "Fire Station");
        staticMap.put("general_contractor", "General Contractor");
        staticMap.put("post_office", "Post Office");
        staticMap.put("fire_station", "Fire Station");
        staticMap.put("health", "Health");
        staticMap.put("lodging", "Lodging");
        staticMap.put("secondary_school", "Secondary School");
        staticMap.put("hospital", "Hospital");
        staticMap.put("meal_takeaway", "Meal Takeaway");
        staticMap.put("drugstore", "Drugstore");
        staticMap.put("hardware_store", "Hardware Store");
        staticMap.put("meal_delivery", "Food Delivery");
        staticMap.put("primary_school", "Primary School");
        staticMap.put("furniture", "Furniture");
    }

    @PostMapping("/api/locations")
    public List<String> postCoords(@RequestBody LocAddress loc) throws IOException {
        String latitude = loc.getLatitude();
        String longitude = loc.getLongitude();
        String radius = loc.getRadius();
        List<String> list = new ArrayList<>();

        if (latitude == null || longitude == null || radius == null) {
            list.add("Please fill in every input!");
            return list;
        }
        if (Math.abs(Double.parseDouble(latitude)) > 180.0 || Math.abs(Double.parseDouble(longitude)) > 180.0) {
            list.add("Please enter coordinates within bounds");
            return list;
        }
        double tempRad = Double.parseDouble(radius);
        if (tempRad < 100.0 || tempRad > 50000.00) {
            radius = "5000.0";
        }

        String strUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + latitude + "%2C"
                + longitude + "&radius=" + radius + "&key=" + apiKey;
        URL url = new URL(strUrl);
        JsonNode json = get(url);

        String status = json.get("status").asText();
        if (!status.equals("OK")) {
            list.add("There are no locations near these coordinates in this range!");
            return list;
        }

        JsonNode results = json.get("results");
        int i = 0;
        while (results.get(i).get("name") != null && i != 10) {

            String currLoc = results.get(i).get("name").asText();
            list.add(currLoc);

            String typeOfLoc = results.get(i).get("types").get(0).asText();
            if (staticMap.containsKey(typeOfLoc)) {
                list.add(staticMap.get(typeOfLoc));
            } else {
                list.add(typeOfLoc);
            }

            String locLat = results.get(i).get("geometry").get("location").get("lat").asText();
            String locLong = results.get(i).get("geometry").get("location").get("lng").asText();
            String dist = distance(latitude, longitude, locLat, locLong);
            list.add(dist.substring(0, 5) + " Miles Away");
            list.add("--");
            i++;
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
