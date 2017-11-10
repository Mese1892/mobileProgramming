package com.home.cata.uclappandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.home.cata.uclappandroid.model.Manager;
import com.home.cata.uclappandroid.model.Team;
import com.home.cata.uclappandroid.repository.TeamRepository;

/**
 * Created by Cata on 10/29/2017.
 */

public class SingleItemView extends Activity {

    EditText txtTeam;
    EditText txtStadium;
    EditText txtManager;
    Button save;
    TeamRepository repository;

    String [] teams=new String [100];
    String [] managers=new String [100];
    String [] stadiums=new String [100];

    int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);

        Intent i= getIntent();

        position=i.getExtras().getInt("position");

        teams= i.getStringArrayExtra("teams");
        stadiums=i.getStringArrayExtra("stadiums");
        managers=i.getStringArrayExtra("managers");

        txtTeam=(EditText) findViewById(R.id.team);
        txtStadium=(EditText) findViewById(R.id.stadium);
        txtManager=(EditText) findViewById(R.id.manager);
        save=(Button) findViewById(R.id.SaveButton);

        txtTeam.setText(teams[position]);
        txtStadium.setText(stadiums[position]);
        txtManager.setText(managers[position]);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTeamName=txtTeam.getText().toString();
                String newStadium= txtStadium.getText().toString();
                String newManager= txtManager.getText().toString();
                Manager m= new Manager();
                m.setName(newManager);
                Team t1= new Team(newTeamName,newStadium,"unseeded",m);
                Team find= repository.findByName(newTeamName);
                find.setName(newTeamName);
                find.setStadium(newStadium);
                find.setManager(m);
                repository.save(find);
                teams[position]=newTeamName;
                stadiums[position]=newStadium;
                managers[position]=newManager;
                Intent i= new Intent(SingleItemView.this, ListViewTeams.class);
                i.putExtra("teams", teams);
                i.putExtra("stadiums",stadiums);
                i.putExtra("managers",managers);
                startActivity(i);
            }
        });




    }
}
