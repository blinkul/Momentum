package com.vvvapps.momentum;

import com.vvvapps.momentum.entities.Day;
import com.vvvapps.momentum.entities.DayObjectiveCrossRef;
import com.vvvapps.momentum.entities.DayWithObjectives;
import com.vvvapps.momentum.entities.Momentum;
import com.vvvapps.momentum.entities.MomentumWithDaysAndObjectives;
import com.vvvapps.momentum.entities.Objective;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class DayDatabaseTest extends DatabaseTestAbstract {

    @Test
    public void insertAndQueryDayWithMomentum() {

        //insert momentum
        Momentum momentum = new Momentum();
        long momentumId = momentumDao.insertMomentum(momentum);

        long objectiveOneId = objectiveDao.insertObjective(new Objective("Play with cat"));
        long objectiveTwoId = objectiveDao.insertObjective(new Objective("Workout"));
        long objectiveThreeId = objectiveDao.insertObjective(new Objective("Sleep"));
        long objectiveFourId = objectiveDao.insertObjective(new Objective("Do makeup"));

        //Add objectives for day one
        LocalDate dateOne = LocalDate.of(1991, Month.JUNE, 15);
        long dayOneId = dayDao.insertDay(new Day(momentumId, dateOne));
        DayObjectiveCrossRef dayOneObjectiveOne = new DayObjectiveCrossRef(dayOneId, objectiveOneId);
        DayObjectiveCrossRef dayOneObjectiveTwo = new DayObjectiveCrossRef(dayOneId, objectiveThreeId);
        DayObjectiveCrossRef dayOneObjectiveThree = new DayObjectiveCrossRef(dayOneId, objectiveFourId);
        objectiveDao.insertObjectiveForDay(dayOneObjectiveOne);
        objectiveDao.insertObjectiveForDay(dayOneObjectiveTwo);
        objectiveDao.insertObjectiveForDay(dayOneObjectiveThree);

        //Add objectives for day one
        LocalDate dateTwo = LocalDate.of(1991, Month.FEBRUARY, 9);
        long dayTwoId = dayDao.insertDay(new Day(momentumId, dateTwo));
        DayObjectiveCrossRef dayTwoObjectiveOne = new DayObjectiveCrossRef(dayTwoId, objectiveOneId);
        DayObjectiveCrossRef dayTwoObjectiveTwo = new DayObjectiveCrossRef(dayTwoId, objectiveTwoId);
        objectiveDao.insertObjectiveForDay(dayTwoObjectiveOne);
        objectiveDao.insertObjectiveForDay(dayTwoObjectiveTwo);

        // Query all days
        MomentumWithDaysAndObjectives momentumFull = momentumDao.queryMomentumWithDaysAndObjectives(momentumId);

        List<DayWithObjectives> daysWithObjectives = momentumFull.getDaysWithObjectives();
        assert daysWithObjectives.size() == 2;

        for (DayWithObjectives day : daysWithObjectives) {
            if (day.getDay().getDate() == dateOne) {
                List<Objective> objectives = day.getObjectives();
                assert objectives.size() == 3;
            }

            if (day.getDay().getDate() == dateTwo) {
                List<Objective> objectives = day.getObjectives();
                assert objectives.size() == 2;
            }
        }

        // Query specific day
        DayWithObjectives dayWithObjectives = dayDao.queryDayWithObjectives(momentumId, dateOne);
        assert dayWithObjectives.getObjectives().size() == 3;

    }
}
