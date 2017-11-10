package com.home.cata.uclappandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.home.cata.uclappandroid.controller.TeamController;
import com.home.cata.uclappandroid.model.Manager;
import com.home.cata.uclappandroid.model.Team;
import com.home.cata.uclappandroid.repository.TeamRepository;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    ListView list;
    TeamsListViewAdapter adapter;
    TeamRepository teamRepository;
    TeamController teamController;
    Button emailPage;
    String []team= new String [100];
    String [] stadiums= new String[100];
    String [] managers=new String[100];

    private void initData(){
        Manager Klopp= new Manager("Jurgen Klopp",50);
        Manager Guardiola=new Manager("Josep Guardiola", 47);
        Manager Mourinho=new Manager("Jose Mourinho", 50);
        Manager Zidane= new Manager("Zinedine ZIdane", 45);
        Team t1=new Team("Liverpool FC","Anfield","Group E",Klopp);
        Team t2= new Team("Manchester City", "Etihad", "Group F", Guardiola);
        Team t3= new Team("Manchester United","Old Trafford", "Group B",Mourinho);
        List<Team> data= Arrays.asList(t1,t2,t3);
        teamRepository= new TeamRepository(data);
        teamController= new TeamController(teamRepository);

        int i=0;

        for (Team t: data) {
            team[i]=t.getName();
            stadiums[i]=t.getStadium();
            managers[i]=t.getManager().getName();
            i++;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);

        this.initData();

        list=(ListView)findViewById(R.id.TeamsListView);
        emailPage=(Button)findViewById(R.id.EmailPageButton);

        adapter= new TeamsListViewAdapter(MainActivity.this,team,stadiums,managers);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(MainActivity.this, SingleItemView.class);
                i.putExtra("teams", team);
                i.putExtra("stadiums",stadiums);
                i.putExtra("managers",managers);
                startActivity(i);
            }
        });

        emailPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,EmailInputForm.class);
                startActivity(i);

            }
        });
    }
}
