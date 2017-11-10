package com.home.cata.uclappandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Cata on 10/29/2017.
 */

public class TeamsListViewAdapter extends BaseAdapter {
    Context context;
    String[] teams=new String [100];
    String[] stadiums=new String [100];
    String[] managers=new String [100];
    LayoutInflater inflater;

    public TeamsListViewAdapter(Context context, String[] teams, String[] stadiums, String[] managers) {
        this.context = context;
        this.teams = teams;
        this.stadiums = stadiums;
        this.managers = managers;
    }

    @Override
    public int getCount() {
        return teams.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtTeam;
        TextView txtStadium;
        TextView txtManager;

        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView= inflater.inflate(R.layout.listview_item,parent,false);

        txtTeam=(TextView) itemView.findViewById(R.id.teamlabel);
       // txtStadium=(TextView) itemView.findViewById(R.id.stadiumlabel);
        //txtManager=(TextView) itemView.findViewById(R.id.managerlabel);

        txtTeam.setText(teams[position]);
       // txtStadium.setText(stadiums[position]);
       // txtManager.setText(managers[position]);

        return itemView;
    }
}
