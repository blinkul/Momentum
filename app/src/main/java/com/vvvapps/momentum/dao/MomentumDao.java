package com.vvvapps.momentum.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.vvvapps.momentum.entities.Momentum;

@Dao
public interface MomentumDao {

    //  === Queries ===

    //  === Inserts ===
    @Insert
    long insertMomentum(Momentum m);

    //  === Updates ===






}
