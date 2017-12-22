package com.home.cata.uclappandroid.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.home.cata.uclappandroid.entities.Manager;

import java.util.List;

/**
 * Created by Catalin on 12/19/2017.
 */

@Dao
public interface ManagerDao {
    @Query("SELECT * FROM manager")
    List<Manager> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Manager manager);

    @Update
    int update(Manager manager);

    @Delete
    void delete(Manager manager);

    @Query("SELECT id FROM manager WHERE name LIKE :name")
    Long findByName(String name);
}
