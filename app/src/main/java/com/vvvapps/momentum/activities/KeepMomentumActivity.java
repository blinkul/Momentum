package com.vvvapps.momentum.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vvvapps.momentum.R;
import com.vvvapps.momentum.database.DatabaseConfig;

public class KeepMomentumActivity extends AppCompatActivity {

    public static final String TAG = KeepMomentumActivity.class.getName();

    // -- UI CONTAINERS --
    private Button planDayButton;
    private Button idStartMomentumButton;
    private TextView dayNumber;
    private ProgressBar momentumBar;
    private LinearLayout idStartMomentumLayout;
    private LinearLayout idMomentumBarLayout;

    // -- DATABASE --
    private final DatabaseConfig db = Room.databaseBuilder(getApplicationContext(), DatabaseConfig.class, "momentum-app-db").build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_momentum);

        initUI();

    }

    private void initUI() {
        planDayButton = findViewById(R.id.idPlanADayButton);
        idStartMomentumButton = findViewById(R.id.idStartMomentumButton);
        dayNumber = findViewById(R.id.idDayNo);
        momentumBar = findViewById(R.id.idMomentumBar);
        idStartMomentumLayout = findViewById(R.id.idStartMomentumLayout);
        idMomentumBarLayout = findViewById(R.id.idMomentumBarLayout);
    }

    // -- UI Buttons Methods --
    public void planDayPress(View view) {
        Log.d(TAG, getString(R.string.plan_day) + " was pressed.");
    }

    public void startMomentumPress(View view) {
        Log.d(TAG, getString(R.string.start_momentum) + " was pressed.");
        displayMomentumIsActive();
        dayNumber.setText("1");
    }
    // -- UI Buttons Methods END --

    private void displayMomentumIsActive() {
        momentumBar.setMax(100);
        idStartMomentumLayout.setVisibility(View.INVISIBLE);
        idMomentumBarLayout.setVisibility(View.VISIBLE);
    }

    private void save() {
    }

    private void load() {
    }


}