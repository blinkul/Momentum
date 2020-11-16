package com.vvvapps.momentum.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.vvvapps.momentum.entities.Day;

import java.time.LocalDate;
import java.util.List;

@Dao
public interface DayDao {

    //  === Queries ===

    @Query("SELECT * FROM Day ORDER BY date")
    List<Day> queryDays();

    @Query("SELECT * FROM Day WHERE date = :date")
    Day queryDayByDate(LocalDate date);

    //  === Inserts ===

    @Transaction
    @Insert
    long insertDay(Day day);

    //  === Updates ===

}
