package com.home.cata.uclappandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        FirebaseDatabase.getInstance().setLogLevel(Logger.Level.DEBUG);

        Button viewTeams = (Button) findViewById(R.id.ViewTeamsButton);
        Button sendEmail = (Button) findViewById(R.id.EmailButton);
        Button book=(Button) findViewById(R.id.book_button);

        viewTeams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListViewTeams.class);
                startActivity(i);
            }
        });

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, EmailInputForm.class);
                startActivity(i);
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BookTeam.class);
                startActivity(i);
            }
        });
    }
}
