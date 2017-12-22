package com.home.cata.uclappandroid;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.home.cata.uclappandroid.entities.Manager;
import com.home.cata.uclappandroid.entities.Team;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    ListView list;
    AppDatabase db;
    TeamsListViewAdapter adapter;


    Button emailPage;
    String[] team = new String[100];
    String[] stadiums = new String[100];
    String[] managers = new String[100];

    private void initData() {
        Manager Klopp = new Manager("Jurgen Klopp", 50);
        Manager Guardiola = new Manager("Josep Guardiola", 47);
        Manager Mourinho = new Manager("Jose Mourinho", 50);
        Manager Zidane = new Manager("Zinedine ZIdane", 45);
        Team t1 = new Team("Liverpool FC", "Anfield", "Group E", Klopp.getId());
        Team t2 = new Team("Manchester City", "Etihad", "Group F", Guardiola.getId());
        Team t3 = new Team("Manchester United", "Old Trafford", "Group B", Mourinho.getId());

        List<Team> data = db.teamDao().getAll();
        List<Manager> datam = db.managerDao().getAll();

        int i = 0;

        for (Team t : data) {
            team[i] = t.getName();
            stadiums[i] = t.getStadium();
            i++;
        }
        int j = 0;
        for (Manager m : datam) {
            managers[j] = m.getName();
            j++;
        }
    }


    public void initDB() {
        Manager Klopp = new Manager("Jurgen Klopp", 50);
        Team t1 = new Team("Liverpool FC", "Anfield", "Group E",Klopp.getId());
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "ucl-app").allowMainThreadQueries()
                                .build();
        long idx=db.teamDao().insert(t1);
        List<Team> teams=db.teamDao().getAll();
        System.out.println("==================   "+ idx+"==========================");
        System.out.println(teams.get(0).toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);

        this.initDB();

        list = (ListView) findViewById(R.id.TeamsListView);
        emailPage = (Button) findViewById(R.id.EmailPageButton);

        adapter = new TeamsListViewAdapter(MainActivity.this, team, stadiums, managers);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, SingleItemView.class);
                i.putExtra("teams", team);
                i.putExtra("stadiums", stadiums);
                i.putExtra("managers", managers);
                startActivity(i);
            }
        });

        emailPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EmailInputForm.class);
                startActivity(i);

            }
        });
    }
}
