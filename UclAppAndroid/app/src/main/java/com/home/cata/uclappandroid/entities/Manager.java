package com.home.cata.uclappandroid.entities;


import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Random;

/**
 * Created by Cata on 10/29/2017.
 */

@IgnoreExtraProperties
public class Manager {

    private Long id;
    private String name;
    private Integer age;

    public Manager() {
    }

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
