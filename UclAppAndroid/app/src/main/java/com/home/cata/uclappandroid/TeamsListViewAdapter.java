package com.home.cata.uclappandroid;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.home.cata.uclappandroid.entities.Team;

import java.util.List;

/**
 * Created by Cata on 10/29/2017.
 */

public class TeamsListViewAdapter extends ArrayAdapter<Team> {
    private Activity context;
    private List<Team> teams;
    private static LayoutInflater inflater;

    public TeamsListViewAdapter(Activity context, List<Team> teams) {
        super(context,0,teams);
        try{
            this.context=context;
            this.teams=teams;
            inflater=context.getLayoutInflater();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public int getCount(){
        return teams.size();
    }

    public Team getItem(Team position){
        return position;
    }



    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView txtTeam;
        View newView=convertView;
        Team t= getItem(position);
        if(convertView ==null){
            newView=inflater.inflate(R.layout.listview_item,null);

        }
        newView.setTag(t.getName());
        txtTeam=(TextView) newView.findViewById(R.id.teamlabel);
        txtTeam.setText(t.getName());

        return newView;
    }
}
