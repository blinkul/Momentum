package com.vvvapps.momentum;

import org.junit.Test;

public class DayDatabaseTest extends DatabaseTestAbstract {

    @Test
    public void insertAndQueryDayWithMomentum() {

//        //insert momentum
//        Momentum momentum = new Momentum();
//        long momentumId = momentumDao.insertMomentum(momentum);
//
//        long objDictOne =
//
//        long objectiveOneId = objectiveDao.insertObjective(new ObjectiveDict("Play with cat"));
//        long objectiveTwoId = objectiveDao.insertObjective(new ObjectiveDict("Workout"));
//        long objectiveThreeId = objectiveDao.insertObjective(new ObjectiveDict("Sleep"));
//        long objectiveFourId = objectiveDao.insertObjective(new ObjectiveDict("Do makeup"));
//
//        //Add objectives for day one
//        LocalDate dateOne = LocalDate.of(1991, Month.JUNE, 15);
//        long dayOneId = dayDao.insertDay(new Day(momentumId, dateOne));
//        ObjectiveWithDictionaryCrossRef dayOneObjectiveOne = new ObjectiveWithDictionaryCrossRef(dayOneId, objectiveOneId);
//        ObjectiveWithDictionaryCrossRef dayOneObjectiveTwo = new ObjectiveWithDictionaryCrossRef(dayOneId, objectiveThreeId);
//        ObjectiveWithDictionaryCrossRef dayOneObjectiveThree = new ObjectiveWithDictionaryCrossRef(dayOneId, objectiveFourId);
//        objectiveDao.insertObjectiveForDay(dayOneObjectiveOne);
//        objectiveDao.insertObjectiveForDay(dayOneObjectiveTwo);
//        objectiveDao.insertObjectiveForDay(dayOneObjectiveThree);
//
//        //Add objectives for day one
//        LocalDate dateTwo = LocalDate.of(1991, Month.FEBRUARY, 9);
//        long dayTwoId = dayDao.insertDay(new Day(momentumId, dateTwo));
//        ObjectiveWithDictionaryCrossRef dayTwoObjectiveOne = new ObjectiveWithDictionaryCrossRef(dayTwoId, objectiveOneId);
//        ObjectiveWithDictionaryCrossRef dayTwoObjectiveTwo = new ObjectiveWithDictionaryCrossRef(dayTwoId, objectiveTwoId);
//        objectiveDao.insertObjectiveForDay(dayTwoObjectiveOne);
//        objectiveDao.insertObjectiveForDay(dayTwoObjectiveTwo);
//
//        // Query all days
//        MomentumWithDaysAndObjectives momentumFull = momentumDao.queryMomentumWithDaysAndObjectives(momentumId);
//
//        List<DayWithObjectives> daysWithObjectives = momentumFull.getDaysWithObjectives();
//        assert daysWithObjectives.size() == 2;
//
//        for (DayWithObjectives day : daysWithObjectives) {
//            if (day.getDay().getDate() == dateOne) {
//                List<ObjectiveDict> objectives = day.getObjectives();
//                assert objectives.size() == 3;
//            }
//
//            if (day.getDay().getDate() == dateTwo) {
//                List<ObjectiveDict> objectives = day.getObjectives();
//                assert objectives.size() == 2;
//            }
//        }
//
//        // Query specific day
//        DayWithObjectives dayWithObjectives = dayDao.queryDayWithObjectives(momentumId, dateOne);
//        assert dayWithObjectives.getObjectives().size() == 3;

    }
}
