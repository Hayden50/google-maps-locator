package com.groupsix.googlemapslocator.OAuth;

// Imports the Google Cloud client library
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import java.util.*;

public class DatastoreController {

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    
    // Method to retrieve username and password given input username
    public List<String> getUserCredentials(String username) {

        List<String> credentials = new ArrayList<>();
        Key key = datastore.newKeyFactory().setKind("User").newKey(username);
        Entity user = datastore.get(key);
        credentials.add(user.getKey().getName());
        credentials.add(user.getString("password"));

        return credentials;
    }

    // Method to create a new user into database
    public void setUserCredentials(String username, String password) {

        Key key = datastore.newKeyFactory().setKind("User").newKey(username);
        Entity user = Entity.newBuilder(key)
        .set("password", password)
        .build();

        datastore.put(user);
    }
}