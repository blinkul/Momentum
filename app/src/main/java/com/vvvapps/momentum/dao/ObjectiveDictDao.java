package com.vvvapps.momentum.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.vvvapps.momentum.entities.ObjectiveDict;

@Dao
public interface ObjectiveDictDao {

    //  === Queries ===

    //  === Inserts ===
    @Insert
    long insertObjectiveDict(ObjectiveDict objectiveDict);

    //  === Updates ===

}
