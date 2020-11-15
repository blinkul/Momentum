package com.vvvapps.momentum;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.vvvapps.momentum.dao.DayDao;
import com.vvvapps.momentum.dao.DayObjectiveCrossRefDao;
import com.vvvapps.momentum.dao.MomentumDao;
import com.vvvapps.momentum.dao.ObjectiveDao;
import com.vvvapps.momentum.database.DatabaseConfig;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public abstract class DatabaseTestAbstract {

    private DatabaseConfig db;

    protected MomentumDao momentumDao;
    protected DayDao dayDao;
    protected ObjectiveDao objectiveDao;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, DatabaseConfig.class).build();
        momentumDao = db.getMomentumDao();
        dayDao = db.getDayDao();
        objectiveDao = db.getObjectiveDao();
    }

    @After
    public void closeDb() {
        db.close();
    }

}
