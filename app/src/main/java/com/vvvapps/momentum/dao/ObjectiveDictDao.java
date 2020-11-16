package com.vvvapps.momentum.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.vvvapps.momentum.entities.ObjectiveDict;

import java.util.List;

@Dao
public interface ObjectiveDictDao {

    //  === Queries ===
    @Query("SELECT * FROM objectivedict ORDER BY description_dict")
    List<ObjectiveDict> queryObjectivesDict();

    //  === Inserts ===
    @Insert
    long insertObjectiveDict(ObjectiveDict objectiveDict);

    //  === Updates ===

}
