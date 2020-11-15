package com.vvvapps.momentum.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.vvvapps.momentum.constants.SQLConstants;

@Entity(indices = {@Index(value = {SQLConstants.OBJECTIVE_DESCRIPTION}, unique = true)})
public class Objective {

    //@Ignore to not persist field

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SQLConstants.OBJECTIVE_ID)
    private long objectiveId;

    @ColumnInfo(name = SQLConstants.OBJECTIVE_DESCRIPTION)
    @NonNull
    private String description;

    public Objective(String description) {
        this.description = description;
    }

    public long getObjectiveId() {
        return objectiveId;
    }

    public void setObjectiveId(long objectiveId) {
        this.objectiveId = objectiveId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
