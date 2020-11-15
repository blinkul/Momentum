package com.vvvapps.momentum.entities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.vvvapps.momentum.constants.SQLConstants;

import java.util.List;

public class DayWithObjectives {

    @Embedded
    private Day day;

    @Relation(
            parentColumn = SQLConstants.DAY_ID,
            entityColumn = SQLConstants.OBJECTIVE_ID,
            associateBy = @Junction(DayObjectiveCrossRef.class)
    )
    private List<Objective> objectives;

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }
}
