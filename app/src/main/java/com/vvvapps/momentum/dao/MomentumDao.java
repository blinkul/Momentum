package com.vvvapps.momentum.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.vvvapps.momentum.entities.DayObjectiveCrossRef;
import com.vvvapps.momentum.entities.Momentum;
import com.vvvapps.momentum.entities.MomentumWithDaysAndObjectives;

import java.time.LocalDate;
import java.util.List;

@Dao
public interface MomentumDao {

    //  === Queries ===

    @Transaction
    @Query("SELECT * FROM Momentum WHERE momentum_id = :momentumId")
    MomentumWithDaysAndObjectives getMomentumById(long momentumId);

    @Transaction
    @Query("SELECT * FROM Momentum WHERE momentum_id = :id")
    MomentumWithDaysAndObjectives queryMomentumWithDaysAndObjectives(long id);

    //  === Inserts ===
    @Insert
    long insertMomentum(Momentum m);

    //  === Updates ===






}
