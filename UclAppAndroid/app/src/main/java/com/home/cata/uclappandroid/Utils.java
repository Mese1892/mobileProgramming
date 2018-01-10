package com.home.cata.uclappandroid;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;

/**
 * Created by Catalin on 1/9/2018.
 */

public class Utils {
    private static FirebaseDatabase database;

    public static FirebaseDatabase getDatabase(){
        if(database==null) {
            database = FirebaseDatabase.getInstance();
            database.setLogLevel(Logger.Level.DEBUG);
            database.setPersistenceEnabled(true);
        }
        return database;
    }
}
