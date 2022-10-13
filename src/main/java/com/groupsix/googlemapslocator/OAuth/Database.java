package com.groupsix.googlemapslocator.OAuth;

// Imports the Google Cloud client library
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
// import java.util.*;

public class Database {
  public static void main(String... args) throws Exception {
    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "User";
    // The name/ID for the new entity
    String username = "nathanhaileyesus";
    String username2 = "haydenrieder";

    // The Cloud Datastore key for the new entity
    Key taskKey = datastore.newKeyFactory().setKind(kind).newKey(username);
    Key taskKey2 = datastore.newKeyFactory().setKind(kind).newKey(username2);

    // Prepares the new entity
    // Entity user = Entity.newBuilder(taskKey).set("nathanhaileyesus", "Buy milk").build();
    Entity user = Entity.newBuilder(taskKey)
     .set("password", "1234")
     .build();

//  datastore.put(user);

    // Saves the entity
    datastore.put(user);

    Entity user2 = Entity.newBuilder(taskKey2)
     .set("password", "abcd")
     .build();

     datastore.put(user2);

    System.out.printf("Saved %s: %s%n", user.getKey().getName(), user.getString("password"));

    // Retrieve entity
    Entity retrieved = datastore.get(taskKey);

    System.out.printf("Retrieved %s: %s%n", taskKey.getName(), retrieved.getString("password"));
  }

}

