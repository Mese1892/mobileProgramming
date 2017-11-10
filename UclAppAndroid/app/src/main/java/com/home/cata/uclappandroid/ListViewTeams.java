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

/**
 * Created by Cata on 10/29/2017.
 */

public class ListViewTeams extends Activity {

    ListView list;
    TeamsListViewAdapter adapter;
    Button emailPage;
    String []teams= new String [100];
    String [] stadiums= new String[100];
    String [] managers=new String[100];

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

        list=(ListView)findViewById(R.id.TeamsListView);

        adapter= new TeamsListViewAdapter(ListViewTeams.this,teams,stadiums,managers);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(ListViewTeams.this, SingleItemView.class);
                i.putExtra("teams", teams);
                i.putExtra("stadiums",stadiums);
                i.putExtra("managers",managers);
                startActivity(i);
            }
        });

        emailPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(ListViewTeams.this,EmailInputForm.class);
                startActivity(i);
            }
        });
    }
}
