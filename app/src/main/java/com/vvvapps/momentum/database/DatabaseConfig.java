package com.vvvapps.momentum.database;

import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.room.TypeConverters;

import com.vvvapps.momentum.converters.LocalDateConverterDatabase;
import com.vvvapps.momentum.dao.DayDao;
import com.vvvapps.momentum.dao.MomentumDao;
import com.vvvapps.momentum.dao.ObjectiveDao;
import com.vvvapps.momentum.dao.ObjectiveDictDao;
import com.vvvapps.momentum.entities.Day;
import com.vvvapps.momentum.entities.Momentum;
import com.vvvapps.momentum.entities.Objective;
import com.vvvapps.momentum.entities.ObjectiveDict;

@Database(
        entities = { Momentum.class, Day.class, Objective.class, ObjectiveDict.class},
        version = 1,
        exportSchema = false
        )
@TypeConverters({LocalDateConverterDatabase.class})
public abstract class DatabaseConfig extends RoomDatabase {

        public abstract MomentumDao getMomentumDao();

        public abstract DayDao getDayDao();

        public abstract ObjectiveDao getObjectiveDao();

        public abstract ObjectiveDictDao getObjectiveDictDao();
}
