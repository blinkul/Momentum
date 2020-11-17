package com.vvvapps.momentum.repository;

import com.vvvapps.momentum.database.DatabaseConfig;
import com.vvvapps.momentum.entities.Momentum;

/**
 * Singleton class to provide a layer between Database and the actual application
 */
public class DatabaseRepository {

    private static DatabaseRepository CONNECTION;
    private final DatabaseConfig config;

    private DatabaseRepository(DatabaseConfig config) {
        this.config = config;
    }

    public static DatabaseRepository getConnection(DatabaseConfig config) {
        if (CONNECTION == null) {
            synchronized (DatabaseRepository.class) {
                CONNECTION = new DatabaseRepository(config);
                return CONNECTION;
            }
        }
        return CONNECTION;
    }

    // METHODS TO PROVIDE LAYER BETWEEN DATABASE AND APPLICATION
    public Momentum getActiveMomentum() {
        return config.getMomentumDao().queryActiveMomentum();
    }

    public Momentum createNewMomentum() {
        Momentum momentum = new Momentum();
        config.getMomentumDao().insertMomentum(momentum);
        return momentum;
    }

}
