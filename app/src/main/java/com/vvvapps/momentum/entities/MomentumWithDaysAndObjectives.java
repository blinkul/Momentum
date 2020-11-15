package com.vvvapps.momentum.entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.vvvapps.momentum.constants.SQLConstants;

import java.util.List;

public class MomentumWithDaysAndObjectives {

    @Embedded
    private Momentum momentum;

    @Relation(
            entity = Day.class,
            parentColumn = SQLConstants.MOMENTUM_ID,
            entityColumn = SQLConstants.DAY_MOMENTUM_FK_ID
    )
    private List<DayWithObjectives> daysWithObjectives;

    public Momentum getMomentum() {
        return momentum;
    }

    public void setMomentum(Momentum momentum) {
        this.momentum = momentum;
    }

    public List<DayWithObjectives> getDaysWithObjectives() {
        return daysWithObjectives;
    }

    public void setDaysWithObjectives(List<DayWithObjectives> daysWithObjectives) {
        this.daysWithObjectives = daysWithObjectives;
    }
}
