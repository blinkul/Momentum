package com.vvvapps.momentum.converters;

import androidx.room.TypeConverter;

import java.time.LocalDate;

public class LocalDateConverterDatabase {

    @TypeConverter
    public static LocalDate fromTimestamp(Long value) {
        return value == null ? null : LocalDate.ofEpochDay(value);
    }

    @TypeConverter
    public static Long localDateToTimestamp(LocalDate date) {
        return date == null ? null : date.toEpochDay();
    }

}
