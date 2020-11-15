package com.vvvapps.momentum.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.vvvapps.momentum.constants.SQLConstants;

@Entity(primaryKeys = {SQLConstants.DAY_ID, SQLConstants.OBJECTIVE_ID})
public class DayObjectiveCrossRef {

    @ColumnInfo(name = SQLConstants.DAY_ID)
    private long dayId;

    @ColumnInfo(name = SQLConstants.OBJECTIVE_ID)
    private long objectiveId;

    public DayObjectiveCrossRef(long dayId, long objectiveId) {
        this.dayId = dayId;
        this.objectiveId = objectiveId;
    }

    public long getDayId() {
        return dayId;
    }

    public void setDayId(long dayId) {
        this.dayId = dayId;
    }

    public long getObjectiveId() {
        return objectiveId;
    }

    public void setObjectiveId(long objectiveId) {
        this.objectiveId = objectiveId;
    }
}
