package com.groupsix.googlemapslocator.OAuth;

// Imports the Google Cloud client library
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import java.util.*;

public class DatastoreController {
    
    // Method to retrieve username and password given input username
  public List<String> getUserCredentials(String username) {

    List<String> credentials = new ArrayList();
    // Entity user = datastore.get(username);
    // credentials.add(user.getKey().getName(), user.getString("password"));

    return credentials;
  }


  public void setUserCredentials(String username, String password) {
    //
  }
}
