package com.vvvapps.momentum.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.vvvapps.momentum.entities.Day;
import com.vvvapps.momentum.entities.DayObjectiveCrossRef;

@Dao
public interface DayDao {

    //  === Queries ===

    @Query("SELECT * FROM day WHERE day_id = :id")
    Day queryDay(long id);

//    @Transaction
//    @Query("SELECT * FROM Day WHERE date = :date")
//    public List<DayWithObjectives> getDayObjectives(LocalDate date);



    //  === Inserts ===
    @Insert
    long insertDay(Day day);

    @Insert
    long insertDayWithObjective(DayObjectiveCrossRef m);

    //  === Updates ===

}
