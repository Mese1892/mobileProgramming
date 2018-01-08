package com.home.cata.uclappandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Logger;
import com.google.firebase.database.ValueEventListener;
import com.home.cata.uclappandroid.entities.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Cata on 10/29/2017.
 */

public class ListViewTeams extends Activity {

    ListView list;
    TeamsListViewAdapter adapter;
    Button addTeam;
    List<Team> teamList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        list = (ListView) findViewById(R.id.TeamsListView);
        addTeam = (Button) findViewById(R.id.AddTeamButton);
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://uclapp-5291c.firebaseio.com/");
        adapter = new TeamsListViewAdapter(ListViewTeams.this, teamList);
        list.setAdapter(adapter);
        databaseReference.child("teams").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                teamList.clear();
                System.out.println("ENTERED LISTENER");
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    System.out.println("ENETERED FOR");
                    Team team = snapshot.getValue(Team.class);
                    teamList.add(team);
                    System.out.println("======================TEAM+++++++++++++++++++");
                }
                adapter = new TeamsListViewAdapter(ListViewTeams.this, teamList);
                list.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("ERRRROROROORORORO");
            }
        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Team t = teamList.get(position);
                Intent i = new Intent(ListViewTeams.this, SingleItemView.class);
                i.putExtra("teamName", t.getName());
                i.putExtra("stadium", t.getStadium());
                i.putExtra("manager", t.getManager());
                i.putExtra("budget", t.getBudget());
                startActivity(i);
            }
        });

        addTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListViewTeams.this, SingleItemView.class);
                i.putExtra("teamName", "");
                i.putExtra("stadium", "");
                i.putExtra("manager", "");
                i.putExtra("budget", 0);
                startActivity(i);

            }
        });

    }
}
