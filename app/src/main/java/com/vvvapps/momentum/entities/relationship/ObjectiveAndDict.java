package com.vvvapps.momentum.entities.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.vvvapps.momentum.constants.SQLConstants;
import com.vvvapps.momentum.entities.Objective;
import com.vvvapps.momentum.entities.ObjectiveDict;

public class ObjectiveAndDict {

    @Embedded
    private Objective objective;

    @Relation(
            parentColumn = SQLConstants.OBJECTIVE_DICT_FK_ID,
            entityColumn = SQLConstants.OBJECTIVE_DICT_ID
    )
    private ObjectiveDict objectiveDict;

    public ObjectiveDict getObjectiveDict() {
        return objectiveDict;
    }

    public void setObjectiveDict(ObjectiveDict objectiveDict) {
        this.objectiveDict = objectiveDict;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }
}
