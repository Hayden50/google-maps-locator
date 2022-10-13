package com.groupsix.googlemapslocator.OAuth;

// import java.util.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;

@RestController
public class LoginController {

    public static void main(String... args) throws Exception {

    }

    private static Datastore datastore;
    // private static String kind;
    // private static String kind2;
    private static Entity user;
    // private static Entity user2;
    // private static Key taskKey;
    // private static Key taskKey2;

    
    static {
        datastore = DatastoreOptions.getDefaultInstance().getService();
        String kind = "User";
        String username = "nathanhaileyesus";
        Key taskKey = datastore.newKeyFactory().setKind(kind).newKey(username);
        user = Entity.newBuilder(taskKey)
         .set("password", "1234")
         .build();
    
        datastore.put(user);
    }




    @PostMapping("/api/login")
    public String postLogin(@RequestBody Login log) {
        
        //Check with database
        String input_username = log.getUsername();
        String input_password = log.getPassword();
        // List<String> list = new ArrayList<>();        

        if (input_username == null) {
            return "There is no user with this username. Please try again or register for an account first.";
        }
        // If username not in database, list.add("There is no user with this username. Please try again or register for an account first.");
        if (input_username.equals(user.getKey().getName()) && input_password.equals(user.getString("password"))) {
            return "Success";
        } else {
            return "Fail";
        }

        // if (input_username == user2.getKey().getName() && input_password == user2.getString("password")) {
        //     return "Success";
        // }


        // If username is in database but incorrect password, list.add("Incorrect password. Please try again.");



        // If username and password are correct, login




        // return "Fail";
    }

    // @PostMapping("/api/register")
    // public void postRegister(@RequestBody Login log) {
    //     String input_username = log.getUsername();
    //     String input_password = log.getPassword();

    //     Key taskKey2 = datastore.newKeyFactory().setKind("User").newKey(input_username);
    //     user = Entity.newBuilder(taskKey2)
    //      .set("password", input_password)
    //      .build();

    }
