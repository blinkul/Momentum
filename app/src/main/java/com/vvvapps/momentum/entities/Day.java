package com.vvvapps.momentum.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.vvvapps.momentum.constants.SQLConstants;

import java.time.LocalDate;

@Entity(indices = {@Index(value = {SQLConstants.DAY_MOMENTUM_FK_ID, SQLConstants.DAY_DATE}, unique = true)})
public class Day {

    //@Ignore to not persist field

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SQLConstants.DAY_ID)
    private long dayId;

    @ColumnInfo(name = SQLConstants.DAY_MOMENTUM_FK_ID)
    @NonNull
    private long momentumId;

    @ColumnInfo(name = SQLConstants.DAY_DATE)
    @NonNull
    private LocalDate date;

    @ColumnInfo(name = SQLConstants.DAY_IS_SUCCESS)
    private boolean isSuccess;

    public Day(@NonNull long momentumId, LocalDate date) {
        this.momentumId = momentumId;
        this.date = date;
    }

    public long getDayId() {
        return dayId;
    }

    public void setDayId(long dayId) {
        this.dayId = dayId;
    }

    public long getMomentumId() {
        return momentumId;
    }

    public void setMomentumId(long momentumId) {
        this.momentumId = momentumId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
