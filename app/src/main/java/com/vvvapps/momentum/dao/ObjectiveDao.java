package com.vvvapps.momentum.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.vvvapps.momentum.entities.Objective;
import com.vvvapps.momentum.entities.relationship.ObjectiveAndDict;

import java.time.LocalDate;
import java.util.List;

@Dao
public interface ObjectiveDao {

    //  === Queries ===
    @Transaction
    @Query("SELECT * FROM objective WHERE fk_objective_day_id = :dayId")
    List<ObjectiveAndDict> queryObjectivesByDayId(long dayId);

    //  === Inserts ===
    @Transaction
    @Insert
    long insertObjective(Objective objective);

    //  === Updates ===
}
