package com.groupsix.googlemapslocator.OAuth;

import java.util.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/api/login")
    public List<String> postLogin(@RequestBody Login log) {
        
        //Check with database
        String username = log.getUsername();
        // String password = log.getPassword();
        List<String> list = new ArrayList<>();


        if (username == null) {
            list.add("There is no user with this username. Please try again or register for an account first.");
            return list;
        }
        // If username not in database, list.add("There is no user with this username. Please try again or register for an account first.");
        


        // If username is in database but incorrect password, list.add("Incorrect password. Please try again.");



        // If username and password are correct, login




        return list;
    }
}
