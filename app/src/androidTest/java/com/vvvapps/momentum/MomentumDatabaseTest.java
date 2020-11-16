package com.vvvapps.momentum;

import com.vvvapps.momentum.entities.Momentum;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class MomentumDatabaseTest extends DatabaseTestAbstract {

    @Test
    public void testInsertMomentum() {
        long momentumId = 30;

        Momentum activeMomentum = new Momentum();
        activeMomentum.setMomentumId(momentumId);
        activeMomentum.setActive(true);
        momentumDao.insertMomentum(activeMomentum);

        Momentum inactiveMomentum = new Momentum();
        activeMomentum.setMomentumId(69);
        activeMomentum.setActive(false);
        momentumDao.insertMomentum(inactiveMomentum);

        Momentum queryActiveMomentum = momentumDao.queryActiveMomentum();
        assert queryActiveMomentum != null;
        assert queryActiveMomentum.getMomentumId() == momentumId;
    }

    @Test
    public void updateMomentum() {
        long momentumId = 30;
        Momentum momentum = new Momentum();
        momentum.setStartDate(LocalDate.now());
        momentum.setMomentumId(momentumId);
        momentum.setActive(true);

        //Insert
        momentumDao.insertMomentum(momentum);

        //Query for the same momentum and change it, then update id to db
        LocalDate endDate = LocalDate.now();

        Momentum queriedMomentum = momentumDao.queryMomentumById(momentumId);
        queriedMomentum.setActive(false);
        queriedMomentum.setEndDate(endDate);

        momentumDao.updateMomentum(queriedMomentum);

        //Verify the update
        List<Momentum> momentums = momentumDao.queryAllMomentums();
        assert momentums.size() == 1;

        Momentum updated = momentumDao.queryMomentumById(momentumId);
        assert updated.isActive() == false;
        assert updated.getEndDate().equals(endDate);

    }

}
