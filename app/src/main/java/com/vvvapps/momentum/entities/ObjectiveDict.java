package com.vvvapps.momentum.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.vvvapps.momentum.constants.SQLConstants;

@Entity(indices = {@Index(value = {SQLConstants.OBJECTIVE_DICT_DESCRIPTION}, unique = true)})
public class ObjectiveDict {

    //@Ignore to not persist field

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SQLConstants.OBJECTIVE_DICT_ID)
    private long objectiveId;

    @ColumnInfo(name = SQLConstants.OBJECTIVE_DICT_DESCRIPTION)
    @NonNull
    private String description;

    public ObjectiveDict(String description) {
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
