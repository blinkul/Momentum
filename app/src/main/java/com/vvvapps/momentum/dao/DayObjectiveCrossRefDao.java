package com.vvvapps.momentum.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.vvvapps.momentum.entities.DayObjectiveCrossRef;
import com.vvvapps.momentum.entities.DayWithObjectives;
import com.vvvapps.momentum.entities.Objective;

import java.time.LocalDate;
import java.util.List;

@Dao
public interface DayObjectiveCrossRefDao {

    //  === Queries ===
    @Query("SELECT * FROM Day WHERE date = :date")
    DayWithObjectives queryObjectivesForDay(LocalDate date);

    //  === Inserts ===
    @Insert
    long insertDayObjectiveCrossRef(DayObjectiveCrossRef dayObjective);

    //  === Updates ===
}
