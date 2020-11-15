package com.vvvapps.momentum;

import android.database.sqlite.SQLiteConstraintException;

import com.vvvapps.momentum.entities.Objective;
import com.vvvapps.momentum.entities.ObjectiveDict;
import com.vvvapps.momentum.entities.relationship.ObjectiveAndDict;

import org.junit.Test;

import java.util.List;

public class ObjectiveDatabaseTest extends DatabaseTestAbstract {

    @Test
    public void testInsertAndRetrieveObjectivesForDay() {
        // Insert Objectives dictionary
        ObjectiveDict dict1 = new ObjectiveDict("Finish The Masterpiece");
        ObjectiveDict dict2 = new ObjectiveDict("Eat salad");
        ObjectiveDict dict3 = new ObjectiveDict("Play with cat");
        long dictId1 = objectiveDictDao.insertObjectiveDict(dict1);
        long dictId2 = objectiveDictDao.insertObjectiveDict(dict2);
        long dictId3 = objectiveDictDao.insertObjectiveDict(dict3);

        long dayOneId = 3;
        long dayTwoId = 6;

        // Insert objective for day one
        Objective o1 = new Objective(dayOneId, dictId1, false);
        Objective o2 = new Objective(dayOneId, dictId2, true);
        objectiveDao.insertObjective(o1);
        objectiveDao.insertObjective(o2);

        // Query objectives for day one
        List<ObjectiveAndDict> objectivesForDayOne = objectiveDao.queryObjectivesByDayId(dayOneId);
        assert objectivesForDayOne.size() == 2;
        assert objectivesForDayOne.get(0).getObjective().isComplete() == false;
        assert objectivesForDayOne.get(1).getObjective().isComplete() == true;

        // Insert objective for day two
        Objective o3 = new Objective(dayTwoId, dictId1, true);
        Objective o4 = new Objective(dayTwoId, dictId2, true);
        Objective o5 = new Objective(dayTwoId, dictId3, true);
        objectiveDao.insertObjective(o3);
        objectiveDao.insertObjective(o4);
        objectiveDao.insertObjective(o5);

        // Query objectives for day two
        List<ObjectiveAndDict> objectivesForDayTwo = objectiveDao.queryObjectivesByDayId(dayTwoId);
        assert objectivesForDayTwo.size() == 3;
        assert objectivesForDayTwo.get(0).getObjective().isComplete() == true;
        assert objectivesForDayTwo.get(1).getObjective().isComplete() == true;
        assert objectivesForDayTwo.get(2).getObjective().isComplete() == true;
    }

    @Test
    public void testUniqueConstraintForObjectivesDict() {
        try {
            ObjectiveDict o1 = new ObjectiveDict("Finish The Masterpiece");
            ObjectiveDict o2 = new ObjectiveDict("Finish The Masterpiece");
            objectiveDictDao.insertObjectiveDict(o1);
            objectiveDictDao.insertObjectiveDict(o2);
            assert false;
        } catch (SQLiteConstraintException e) {
            assert true;
        }
    }

    @Test
    public void testUniqueConstraintForObjectives() {
        try {
            Objective o1 = new Objective(1, 2, false);
            Objective o2 = new Objective(1, 2, true);
            objectiveDao.insertObjective(o1);
            objectiveDao.insertObjective(o2);
            assert false;
        } catch (SQLiteConstraintException e) {
            assert true;
        }
    }

}
