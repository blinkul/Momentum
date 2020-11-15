package com.vvvapps.momentum;

import android.database.sqlite.SQLiteConstraintException;

import com.vvvapps.momentum.entities.Objective;

import org.junit.Test;

import java.util.List;

public class ObjectiveDatabaseTest extends DatabaseTestAbstract {

    @Test
    public void testObjectivesInsertAndQueryAll() {
        Objective o1 = new Objective("Finish The Masterpiece");
        Objective o2 = new Objective("Eat salad");
        Objective o3 = new Objective("Play with cat");
        objectiveDao.insertObjective(o1);
        objectiveDao.insertObjective(o2);
        objectiveDao.insertObjective(o3);

        List<Objective> objectives = objectiveDao.queryObjectives();
        assert objectives.size() == 3;
    }

    @Test
    public void testBreakUniqueConstraint() {
        try {
            Objective o1 = new Objective("Finish The Masterpiece");
            Objective o2 = new Objective("Finish The Masterpiece");
            objectiveDao.insertObjective(o1);
            objectiveDao.insertObjective(o2);
            assert false;
        } catch (SQLiteConstraintException e) {
            assert true;
        }
    }

}
