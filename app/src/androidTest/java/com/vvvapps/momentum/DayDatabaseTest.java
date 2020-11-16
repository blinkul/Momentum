package com.vvvapps.momentum;

import android.database.sqlite.SQLiteConstraintException;

import com.vvvapps.momentum.entities.Day;
import com.vvvapps.momentum.entities.Momentum;
import com.vvvapps.momentum.entities.Objective;
import com.vvvapps.momentum.entities.ObjectiveDict;
import com.vvvapps.momentum.entities.relationship.ObjectiveAndDict;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class DayDatabaseTest extends DatabaseTestAbstract {

    @Test
    public void insertAndQueryDayWithMomentum() {

        //Insert momentum
        Momentum m = new Momentum();
        m.setMomentumId(3);

        //Insert Objective dictionary
        ObjectiveDict dict1 = new ObjectiveDict("Spal pisica");
        dict1.setObjectiveDictId(1);
        objectiveDictDao.insertObjectiveDict(dict1);

        ObjectiveDict dict2 = new ObjectiveDict("Mut masina");
        dict2.setObjectiveDictId(2);
        objectiveDictDao.insertObjectiveDict(dict2);

        ObjectiveDict dict3 = new ObjectiveDict("Dau besina");
        dict3.setObjectiveDictId(3);
        objectiveDictDao.insertObjectiveDict(dict3);

        List<ObjectiveDict> objectiveDictList = objectiveDictDao.queryObjectivesDict();
        assert objectiveDictList.size() == 3;

        //Insert planned days in the momentum
        Day d1 = new Day(m.getMomentumId(), LocalDate.of(2020, Month.DECEMBER, 25));
        d1.setDayId(10);
        dayDao.insertDay(d1);

        Day d2 = new Day(m.getMomentumId(), LocalDate.of(2020, Month.MARCH, 12));
        d2.setDayId(20);
        dayDao.insertDay(d2);

        List<Day> days = dayDao.queryDays();
        assert days.size() == 2;

        //Insert objectives for days
        Objective o1 = new Objective(d1.getDayId(), dict1.getObjectiveDictId(), true);
        o1.setObjectiveId(1);
        objectiveDao.insertObjective(o1);

        Objective o2 = new Objective(d1.getDayId(), dict2.getObjectiveDictId(), false);
        o2.setObjectiveId(2);
        objectiveDao.insertObjective(o2);

        Objective o3 = new Objective(d1.getDayId(), dict3.getObjectiveDictId(), false);
        o2.setObjectiveId(3);
        objectiveDao.insertObjective(o3);

        Objective o4 = new Objective(d2.getDayId(), dict1.getObjectiveDictId(), false);
        o4.setObjectiveId(4);
        objectiveDao.insertObjective(o4);

        Objective o5 = new Objective(d2.getDayId(), dict2.getObjectiveDictId(), false);
        o5.setObjectiveId(5);
        objectiveDao.insertObjective(o5);

        Day queryDayOne = dayDao.queryDayByDate(d1.getDate());
        List<ObjectiveAndDict> objectivesDayOne = objectiveDao.queryObjectivesByDayId(queryDayOne.getDayId());
        assert objectivesDayOne.size() == 3;
        assert objectivesDayOne.get(0).getObjective().isComplete() == true;
        assert objectivesDayOne.get(1).getObjective().isComplete() == false;
        assert objectivesDayOne.get(2).getObjective().isComplete() == false;

        Day queryDayTwo = dayDao.queryDayByDate(d2.getDate());
        List<ObjectiveAndDict> objectivesDayTwo = objectiveDao.queryObjectivesByDayId(queryDayTwo.getDayId());
        assert objectivesDayTwo.size() == 2;
        assert objectivesDayTwo.get(0).getObjective().isComplete() == false;
        assert objectivesDayTwo.get(1).getObjective().isComplete() == false;
    }

    @Test
    public void testUniqueConstraintForDayId() {
        long momentumId = 3;
        long dayId = 10;
        try {
            Day d1 = new Day(momentumId, LocalDate.now());
            d1.setDayId(dayId);
            Day d2 = new Day(momentumId, LocalDate.now().plus(2, ChronoUnit.DAYS));
            d2.setDayId(dayId);

            dayDao.insertDay(d1);
            dayDao.insertDay(d2);
            assert false;
        } catch (SQLiteConstraintException e) {
            assert true;
        }
    }

    @Test
    public void testUniqueConstraintForSameMomentumAndDay() {
        long momentumId = 3;
        LocalDate date = LocalDate.now();
        try {
            Day d1 = new Day(momentumId, date);
            d1.setDayId(10);
            Day d2 = new Day(momentumId, date);
            d2.setDayId(20);

            dayDao.insertDay(d1);
            dayDao.insertDay(d2);
            assert false;
        } catch (SQLiteConstraintException e) {
            assert true;
        }
    }
}
