package com.vvvapps.momentum.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.vvvapps.momentum.entities.Momentum;

import java.util.List;

@Dao
public interface MomentumDao {

    //  === Queries ===
    @Query("SELECT * FROM momentum WHERE is_active = 1")
    Momentum queryActiveMomentum();

    @Query("SELECT * FROM momentum WHERE momentum_id = :momentumId")
    Momentum queryMomentumById(long momentumId);

    @Query("SELECT * FROM momentum ORDER BY momentum_id")
    List<Momentum> queryAllMomentums();

    //  === Inserts ===
    @Insert
    long insertMomentum(Momentum m);

    //  === Updates ===
    @Update
    void updateMomentum(Momentum m);

}
