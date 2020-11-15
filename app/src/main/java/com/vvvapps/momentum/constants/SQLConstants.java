package com.vvvapps.momentum.constants;

public class SQLConstants {

    //Momentum table
    public static final String MOMENTUM_ID = "momentum_id";
    public static final String MOMENTUM_START_DATE = "start_date";
    public static final String MOMENTUM_END_DATE = "end_date";
    public static final String MOMENTUM_IS_ACTIVE = "is_active";

    //Day table
    public static final String DAY_ID = "day_id";
    public static final String DAY_DATE = "date";
    public static final String DAY_MOMENTUM_FK_ID = "fk_momentum_id";
    public static final String DAY_IS_SUCCESS = "is_success";

    //Objective table
    public static final String OBJECTIVE_ID = "objective_id";
    public static final String OBJECTIVE_DESCRIPTION = "description";

}
