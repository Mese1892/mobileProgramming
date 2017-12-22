package com.home.cata.uclappandroid.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Random;

/**
 * Created by Cata on 10/29/2017.
 */

@Entity
public class Manager {

    @PrimaryKey
    private Long id;
    private String name;
    private Integer age;


    public Manager(String name, Integer age) {
        Random rnd= new Random();
        this.id=rnd.nextLong() ;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
