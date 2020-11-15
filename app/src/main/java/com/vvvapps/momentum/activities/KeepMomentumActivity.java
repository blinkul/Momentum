package com.vvvapps.momentum.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vvvapps.momentum.R;
import com.vvvapps.momentum.database.DatabaseConfig;

import java.util.Date;

//TODO: Saving should occur after each click

public class KeepMomentumActivity extends AppCompatActivity {

    public static final String TAG = KeepMomentumActivity.class.getName();

    private static final String IS_MOMENTUM_STARTED_KEY = "isMomentumStarted";
    private static final String MOMENTUM_START_DATE_KEY = "momentumStartDate";

    private Date momentumStartDate;
    private boolean isMomentumStarted;

    private Button planDayButton;
    private Button idStartMomentumButton;
    private TextView dayNumber;
    private ProgressBar momentumBar;
    private LinearLayout idStartMomentumLayout;
    private LinearLayout idMomentumBarLayout;

    private final DatabaseConfig db = Room.databaseBuilder(
                getApplicationContext(), DatabaseConfig.class, "momentum-app"
            ).build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_momentum);

        init();
//        loadState(savedInstanceState);



    }

    private void init() {
        planDayButton = findViewById(R.id.idPlanADayButton);
        idStartMomentumButton = findViewById(R.id.idStartMomentumButton);
        dayNumber = findViewById(R.id.idDayNo);
        momentumBar = findViewById(R.id.idMomentumBar);
        idStartMomentumLayout = findViewById(R.id.idStartMomentumLayout);
        idMomentumBarLayout = findViewById(R.id.idMomentumBarLayout);
    }

//    private void loadState(@NonNull Bundle savedInstanceState) {
//        Log.d(TAG, "LOADING ACTIVITY STATE - savedInstanceState = " + savedInstanceState);
//        if (savedInstanceState == null || !isMomentumStarted) {
//            idStartMomentumLayout.setVisibility(View.VISIBLE);
//            idMomentumBarLayout.setVisibility(View.INVISIBLE);
//            return;
//        }
//
//        isMomentumStarted = savedInstanceState.getBoolean(IS_MOMENTUM_STARTED_KEY);
//        momentumStartDate = (Date) savedInstanceState.getSerializable(MOMENTUM_START_DATE_KEY);
//
//        if (isMomentumStarted) {
//            displayMomentumIsActive();
//            long diff = new Date().getTime() - momentumStartDate.getTime();
//            dayNumber.setText(String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)));
//        }
//    }

    public void planDayPress(View view) {
        Log.d(TAG, getString(R.string.plan_day) + " was pressed.");
    }

    public void startMomentumPress(View view) {
        Log.d(TAG, getString(R.string.start_momentum) + " was pressed.");
        displayMomentumIsActive();
        isMomentumStarted = true;
        dayNumber.setText("1");
        momentumStartDate = new Date();
    }

    private void displayMomentumIsActive() {
        momentumBar.setMax(100);
        idStartMomentumLayout.setVisibility(View.INVISIBLE);
        idMomentumBarLayout.setVisibility(View.VISIBLE);
    }

    private void save() {
        Log.d(TAG, "SAVING ACTIVITY STATE");
        SharedPreferences.Editor editor = getPreferences(Context.MODE_PRIVATE).edit();
        editor.putBoolean(IS_MOMENTUM_STARTED_KEY, isMomentumStarted);
//        editor.

//        outState.putBoolean(IS_MOMENTUM_STARTED_KEY, isMomentumStarted);
//        outState.putSerializable(MOMENTUM_START_DATE_KEY, momentumStartDate);
    }

    private void load() {
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);

    }


}