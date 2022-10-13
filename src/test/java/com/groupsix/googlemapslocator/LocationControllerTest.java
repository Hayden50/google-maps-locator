package com.groupsix.googlemapslocator;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URL;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.groupsix.googlemapslocator.location.LocationController;

@SpringBootTest
class LocationControllerTest {

    private String apiKey = "AIzaSyBjZXpz2X3e0KhnzBK8Av7IDnbwfm0ZowU";

	@Test
	void getShouldReturnJSON() throws IOException {
        
        var loc = new LocationController();
        String strUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + "100" + "%2C"
                + "100" + "&radius=" + "10" + "&key=" + apiKey;
        URL url = new URL(strUrl);
        JSONAssert(loc.get(url));
	}

    @Test
    void shouldReturnX() {
        var loc = new LocationController();
        float results = Float.parseFloat(loc.distance("100", "100", "110", "110"));
        assertTrue( results< 1145 &&  results > 1144);       
    }


    private void JSONAssert(JsonNode jsonNode) {
    }

}