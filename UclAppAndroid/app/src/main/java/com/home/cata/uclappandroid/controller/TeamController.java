package com.home.cata.uclappandroid.controller;

import com.home.cata.uclappandroid.AppDatabase;
import com.home.cata.uclappandroid.entities.Team;

import java.util.List;

/**
 * Created by Catalin on 12/19/2017.
 */

public class TeamController {

    private AppDatabase db;


    public List<Team> getAll() {
        return db.teamDao().getAll();
    }

    public long save(String name, String stadium, String group, String managerName) {

        Long id= db.managerDao().findByName(managerName);

        Team t= new Team(name, stadium,group,id);

        return db.teamDao().insert(t);
    }
}
