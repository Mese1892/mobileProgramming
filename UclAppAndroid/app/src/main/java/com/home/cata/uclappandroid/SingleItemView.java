package com.home.cata.uclappandroid;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.home.cata.uclappandroid.entities.Team;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

/**
 * Created by Cata on 10/29/2017.
 */

public class SingleItemView extends Activity {

    EditText txtTeam;
    EditText txtStadium;
    EditText txtManager;
    EditText txtBudget;
    Button save;
    Button delete;
    Button update;
    GraphView graphView;

    String teamName;
    String manager;
    String stadium;
    Integer budget;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);

        Intent i = getIntent();


        teamName = i.getStringExtra("teamName");
        stadium = i.getStringExtra("stadium");
        manager = i.getStringExtra("manager");
        budget = i.getIntExtra("budget", 0);


        txtTeam = (EditText) findViewById(R.id.team);
        txtStadium = (EditText) findViewById(R.id.stadium);
        txtManager = (EditText) findViewById(R.id.manager);
        txtBudget = (EditText) findViewById(R.id.bugetEdit);
        save = (Button) findViewById(R.id.SaveButton);
        delete = (Button) findViewById(R.id.DeleteButton);
        update = (Button) findViewById(R.id.UpdateButton);
        graphView = (GraphView) findViewById(R.id.graph);


        txtTeam.setText(teamName);
        txtStadium.setText(stadium);
        txtManager.setText(manager);
        txtBudget.setText(budget.toString());


        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://uclapp-5291c.firebaseio.com/");

        databaseReference.child("teams").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataPoint[] dataPoints = new DataPoint[30];
                int k = 0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    if (dataSnapshot1.exists()) {
                        Team team = dataSnapshot1.getValue(Team.class);
                        try {
                            dataPoints[k] = new DataPoint(k, team.getBudget());
                        } catch (NullPointerException ex) {
                            dataPoints[k] = new DataPoint(k, 0);
                        }
                        k++;
                    }
                }

                DataPoint[] dp = new DataPoint[k];
                for (int i = 0; i < k; i++) {
                    dp[i] = dataPoints[i];
                }

                BarGraphSeries<DataPoint> stats = new BarGraphSeries<>(dp);
                stats.setSpacing(50);
                stats.setDrawValuesOnTop(true);
                stats.setValuesOnTopColor(Color.BLACK);
                System.out.println("GRAPH VIEW" + graphView.toString());
                graphView.addSeries(stats);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("ERRRRORRRR CHARTS");
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTeam();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteTeam();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTeam();
            }
        });

    }

    private void updateTeam() {
        String name = txtTeam.getText().toString();
        String stadium = txtStadium.getText().toString().trim();
        String manager = txtManager.getText().toString().trim();
        Integer budget = Integer.parseInt(txtBudget.getText().toString().trim());
        if (!TextUtils.isEmpty(name)) {

            databaseReference.child("teams").child(name).child("stadium").setValue(stadium);
            databaseReference.child("teams").child(name).child("manager").setValue(manager);
            databaseReference.child("teams").child(name).child("budget").setValue(budget);
            Toast.makeText(this, "Team updated", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Please enter a team name", Toast.LENGTH_LONG).show();
        }
    }

    private void deleteTeam() {
        String name = txtTeam.getText().toString();
        databaseReference.child("teams").child(name).removeValue();
        Toast.makeText(this, "Team removed", Toast.LENGTH_LONG).show();


    }

    private void addTeam() {
        String name = txtTeam.getText().toString().trim();
        String stadium = txtStadium.getText().toString().trim();
        String manager = txtManager.getText().toString().trim();
        Integer budget = Integer.parseInt(txtBudget.getText().toString().trim());


        if (!TextUtils.isEmpty(name)) {

            Team team = new Team(name, stadium, manager, budget);
            databaseReference.child("teams").child(team.getName()).setValue(team);
            NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.champions)
                    .setContentTitle("UCLAPP").setContentText("Team saved!");
            int notific=001;
            NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(notific,builder.build());
        } else {
            Toast.makeText(this, "Please enter a team name", Toast.LENGTH_LONG).show();
        }
    }
}
