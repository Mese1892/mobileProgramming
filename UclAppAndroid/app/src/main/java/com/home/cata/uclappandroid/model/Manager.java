package com.home.cata.uclappandroid.model;

/**
 * Created by Cata on 10/29/2017.
 */

public class Manager {
    private String name;
    private Integer age;
  //  private Integer team;

    public Manager() {
    }

    public Manager(String name, Integer age) {
        this.name = name;
        this.age = age;
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

//    public Integer getTeam() {
//        return team;
//    }
//
//    public void setTeam(Integer team) {
//        this.team = team;
//    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
