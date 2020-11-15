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
    // TODO: create test for this
    @Query("SELECT * FROM Objective ORDER BY fk_objective_dict_id ASC")
    List<Objective> queryObjectives();

    @Transaction
    @Query("SELECT * FROM objective WHERE fk_objective_day_id = :dayId")
    List<ObjectiveAndDict> queryObjectivesByDayId(long dayId);


    //  === Inserts ===

    @Insert
    long insertObjective(Objective objective);

    //  === Updates ===
}
