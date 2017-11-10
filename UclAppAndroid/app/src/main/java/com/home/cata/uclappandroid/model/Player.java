package com.home.cata.uclappandroid.model;

/**
 * Created by Cata on 10/29/2017.
 */

public class Player {
    private String name;
    private String position;
    private Integer age;
    private Integer team;
    private Boolean isCaptain;
    private Integer gamesPlayed;
    private Integer goalsScored;
    private Integer assists;

    public Player() {
    }

    public Player(String name, String position, Integer age, Integer team, Boolean isCaptain, Integer gamesPlayed, Integer goalsScored, Integer assists) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.team = team;
        this.isCaptain = isCaptain;
        this.gamesPlayed = gamesPlayed;
        this.goalsScored = goalsScored;
        this.assists = assists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }

    public Boolean getCaptain() {
        return isCaptain;
    }

    public void setCaptain(Boolean captain) {
        isCaptain = captain;
    }

    public Integer getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public Integer getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(Integer goalsScored) {
        this.goalsScored = goalsScored;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                '}';
    }
}
