package com.vvvapps.momentum.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.vvvapps.momentum.constants.SQLConstants;

import java.time.LocalDate;

/*
TODO: Redefine database

Momentum one-to-many Day
Day one-to-many Objectives (includes status)
Objectives many-to-many ObjectivesDict

 */

@Entity
public class Momentum {

    //@Ignore to not persist field

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SQLConstants.MOMENTUM_ID)
    private long momentumId;

    @ColumnInfo(name = SQLConstants.MOMENTUM_START_DATE)
    @NonNull
    private LocalDate startDate;

    @ColumnInfo(name = SQLConstants.MOMENTUM_END_DATE)
    private LocalDate endDate;

    @ColumnInfo(name = SQLConstants.MOMENTUM_IS_ACTIVE)
    private boolean isActive;

    public Momentum() {
        startDate = LocalDate.now();
    }

    public long getMomentumId() {
        return momentumId;
    }

    public void setMomentumId(long momentumId) {
        this.momentumId = momentumId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
