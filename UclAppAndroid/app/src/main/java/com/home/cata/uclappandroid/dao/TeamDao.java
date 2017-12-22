package com.home.cata.uclappandroid.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.home.cata.uclappandroid.entities.Team;

import java.util.List;

/**
 * Created by Catalin on 12/19/2017.
 */

@Dao
public interface TeamDao {

    @Query("SELECT * FROM team")
    List<Team> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Team team);

    @Update
    int update(Team team);

    @Delete
    void delete(Team team);
}
