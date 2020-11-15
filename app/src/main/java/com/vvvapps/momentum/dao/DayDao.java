package com.vvvapps.momentum.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.vvvapps.momentum.entities.Day;
import com.vvvapps.momentum.entities.relationship.DayWithObjectives;

import java.time.LocalDate;

@Dao
public interface DayDao {

    //  === Queries ===
    //TODO: Include in test
    @Transaction
    @Query("SELECT * FROM Day WHERE fk_momentum_id = :momentumId AND date = :date")
    DayWithObjectives queryDayWithObjectives(long momentumId, LocalDate date);

    //  === Inserts ===
    //TODO: Include in test
    @Insert
    long insertDay(Day day);

    //  === Updates ===

}
