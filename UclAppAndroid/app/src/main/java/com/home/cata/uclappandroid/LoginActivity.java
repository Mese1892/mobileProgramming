package com.home.cata.uclappandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Catalin on 1/9/2018.
 */

public class LoginActivity extends AppCompatActivity {

    private static  final String LG="FIREBASE AUTH";
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener listener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
