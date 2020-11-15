package com.vvvapps.momentum.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.vvvapps.momentum.entities.DayObjectiveCrossRef;
import com.vvvapps.momentum.entities.Objective;

import java.util.List;

@Dao
public interface ObjectiveDao {

    //  === Queries ===
    @Query("SELECT * FROM objective ORDER BY description ASC")
    List<Objective> queryObjectives();


    //  === Inserts ===

    @Insert
    long insertObjective(Objective objective);

    @Transaction
    @Insert
    long insertObjectiveForDay(DayObjectiveCrossRef m);

    //  === Updates ===
}
