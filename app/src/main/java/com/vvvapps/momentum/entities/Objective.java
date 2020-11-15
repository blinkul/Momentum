package com.vvvapps.momentum.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.vvvapps.momentum.constants.SQLConstants;

@Entity(indices = {@Index(value = {SQLConstants.OBJECTIVE_DAY_FK_ID, SQLConstants.OBJECTIVE_DICT_FK_ID}, unique = true)})
public class Objective {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SQLConstants.OBJECTIVE_ID)
    private long objectiveId;

    @ColumnInfo(name = SQLConstants.OBJECTIVE_DAY_FK_ID)
    @NonNull
    private long dayId;

    @ColumnInfo(name = SQLConstants.OBJECTIVE_DICT_FK_ID)
    @NonNull
    private long objectiveDictId;

    @ColumnInfo(name = SQLConstants.OBJECTIVE_IS_COMPLETE)
    private boolean isComplete;

    public Objective(long dayId, long objectiveDictId, boolean isComplete) {
        this.isComplete = isComplete;
        this.dayId = dayId;
        this.objectiveDictId = objectiveDictId;
    }

    public long getObjectiveId() {
        return objectiveId;
    }

    public void setObjectiveId(long objectiveId) {
        this.objectiveId = objectiveId;
    }

    public long getDayId() {
        return dayId;
    }

    public void setDayId(long dayId) {
        this.dayId = dayId;
    }

    public long getObjectiveDictId() {
        return objectiveDictId;
    }

    public void setObjectiveDictId(long objectiveDictId) {
        this.objectiveDictId = objectiveDictId;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
