package com.home.cata.uclappandroid.controller;

import com.home.cata.uclappandroid.model.Team;
import com.home.cata.uclappandroid.repository.TeamRepository;

import java.util.List;

/**
 * Created by Cata on 10/29/2017.
 */

public class TeamController {
    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    public List<Team> getAll(){
       return this.teamRepository.getAll();
    }
}
