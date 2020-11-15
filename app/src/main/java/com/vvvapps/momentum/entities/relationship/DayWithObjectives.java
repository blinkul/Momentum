package com.vvvapps.momentum.entities.relationship;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.vvvapps.momentum.constants.SQLConstants;
import com.vvvapps.momentum.entities.Day;
import com.vvvapps.momentum.entities.Objective;

import java.util.List;

public class DayWithObjectives {

    @Embedded
    private Day day;

    @Relation(
            entity = Objective.class,
            parentColumn = SQLConstants.DAY_ID,
            entityColumn = SQLConstants.OBJECTIVE_ID
    )
    private List<Objective> objectives;

    public DayWithObjectives(Day day) {
        this.day = day;
    }

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
