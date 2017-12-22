package com.home.cata.uclappandroid;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.home.cata.uclappandroid.dao.ManagerDao;
import com.home.cata.uclappandroid.dao.TeamDao;
import com.home.cata.uclappandroid.entities.Manager;
import com.home.cata.uclappandroid.entities.Team;

/**
 * Created by Catalin on 12/19/2017.
 */

@Database(entities = {Team.class, Manager.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TeamDao teamDao();

    public abstract ManagerDao managerDao();

}
