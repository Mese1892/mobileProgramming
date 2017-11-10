package com.home.cata.uclappandroid.model;

import java.util.ArrayList;

/**
 * Created by Cata on 10/29/2017.
 */

public class Team {
    private String name;
    private String stadium;
    private String group;
   // private ArrayList<Player> players;
    private Manager manager;

    public Team(String name, String stadium, String group, ArrayList<Player> players, Manager manager) {
        this.name = name;
        this.stadium = stadium;
        this.group = group;
       // this.players = players;
        this.manager = manager;
    }

    public Team(String name, String stadium, String group, Manager manager) {
        this.name = name;
        this.stadium = stadium;
        this.group = group;
        this.manager = manager;
    }

    public Team() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

//    public ArrayList<Player> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(ArrayList<Player> players) {
//        this.players = players;
//    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
