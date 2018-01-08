package com.home.cata.uclappandroid.entities;


import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Random;

/**
 * Created by Cata on 10/29/2017.
 */

@IgnoreExtraProperties
public class Team {

    private Long id;
    private String name;
    private String stadium;
    private String manager;
    private Integer budget;

    public Team(String name, String stadium, String manager) {
        Random rnd= new Random();
        this.id=rnd.nextLong() ;
        this.name = name;
        this.stadium = stadium;
        this.manager = manager;
    }

    public Team(String name, String stadium, String manager, Integer buget) {
        Random rnd= new Random();
        this.name = name;
        this.stadium = stadium;
        this.manager = manager;
        this.budget = buget;
    }

    public Team() {
    }

    public Long getId() {
        return id;
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


    public String getManager() {
        return manager;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", stadium='" + stadium + '\'' +
                ", manager=" + manager +
                '}';
    }
}
