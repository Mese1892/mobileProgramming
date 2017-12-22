package com.home.cata.uclappandroid.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.Random;

/**
 * Created by Cata on 10/29/2017.
 */


@Entity(foreignKeys = @ForeignKey(entity = Manager.class,
                                    parentColumns = "id",
                                    childColumns = "manager"),
        indices = {@Index(value="manager", unique = true)})
public class Team {

    @PrimaryKey
    private Long id;
    private String name;
    private String stadium;
    private String group;
    private Long manager;

    public Team(String name, String stadium, String group, Long manager) {
        Random rnd= new Random();
        this.id=rnd.nextLong() ;
        this.name = name;
        this.stadium = stadium;
        this.group = group;
        this.manager = manager;
    }

    @Ignore
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Long getManager() {
        return manager;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", stadium='" + stadium + '\'' +
                ", group='" + group + '\'' +
                ", manager=" + manager +
                '}';
    }
}
