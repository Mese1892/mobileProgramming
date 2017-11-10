package com.home.cata.uclappandroid.repository;

import com.home.cata.uclappandroid.model.Team;

import java.util.List;

/**
 * Created by Cata on 10/29/2017.
 */

public class TeamRepository {
    private List<Team> teams;

    public TeamRepository() {
    }

    public TeamRepository(List<Team> teams) {
        this.teams = teams;
    }

    public List<Team> getAll(){
        return teams;
    }

    public Team findByName(String name){
        Team aux= new Team();
        for (Team t: teams){
            if (t.getName()==name){
                aux=t;
            }
        }
        return aux;
    }
    public void save(Team t){
        Team aux=findByName(t.getName());
        if(aux.getName()==null){
            teams.add(t);
        }
        else{
            for (Team x: teams){
                x.setManager(t.getManager());
                x.setStadium(t.getStadium());
            }

        }
    }
}
