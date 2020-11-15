package com.vvvapps.momentum;

import com.vvvapps.momentum.entities.Day;
import com.vvvapps.momentum.entities.DayObjectiveCrossRef;
import com.vvvapps.momentum.entities.DayWithObjectives;
import com.vvvapps.momentum.entities.Objective;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class DayDatabaseTest extends DatabaseTestAbstract {

    @Test
    public void testInsertAndQueryDay() {
        LocalDate testDateOne = LocalDate.of(1991, Month.FEBRUARY, 9);
        LocalDate testDateTwo = LocalDate.of(1991, Month.JUNE, 15);

        Day dayOne = new Day(testDateOne);
        Day dayTwo = new Day(testDateTwo);

        long idOne = dayDao.insertDay(dayOne);
        long idTwo = dayDao.insertDay(dayTwo);

        Day result = dayDao.queryDay(idTwo);

        assert result.getDate().toEpochDay() == testDateTwo.toEpochDay();
    }

    @Test
    public void testInsertAndQueryDayWithObjectives() {
        Objective o1 = new Objective("Finish The Masterpiece");
        Objective o2 = new Objective("Eat salad");
        Objective o3 = new Objective("Play with cat");
        long idObj1 = objectiveDao.insertObjective(o1);
        long idObj2 = objectiveDao.insertObjective(o2);
        long idObj3 = objectiveDao.insertObjective(o3);

        LocalDate testDateOne = LocalDate.of(1991, Month.FEBRUARY, 9);
        LocalDate testDateTwo = LocalDate.of(1991, Month.JUNE, 15);
        Day dayOne = new Day(testDateOne);
        Day dayTwo = new Day(testDateTwo);
        long idDay1 = dayDao.insertDay(dayOne);
        long idDay2 = dayDao.insertDay(dayTwo);

        DayObjectiveCrossRef day1 = new DayObjectiveCrossRef(idDay1, idObj1);
        DayObjectiveCrossRef day2 = new DayObjectiveCrossRef(idDay2, idObj2);
        DayObjectiveCrossRef day3 = new DayObjectiveCrossRef(idDay2, idObj3);
        dayObjectiveCrossRefDao.insertDayObjectiveCrossRef(day1);
        dayObjectiveCrossRefDao.insertDayObjectiveCrossRef(day2);
        dayObjectiveCrossRefDao.insertDayObjectiveCrossRef(day3);

        DayWithObjectives dayWithObjectivesOne = dayObjectiveCrossRefDao.queryObjectivesForDay(testDateOne);
        assert dayWithObjectivesOne.getObjectives().size() == 1;

        DayWithObjectives dayWithObjectivesTwo = dayObjectiveCrossRefDao.queryObjectivesForDay(testDateTwo);
        assert dayWithObjectivesTwo.getObjectives().size() == 2;

    }

}
