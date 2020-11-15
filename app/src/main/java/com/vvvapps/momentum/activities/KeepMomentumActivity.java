package com.vvvapps.momentum.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.vvvapps.momentum.entities.Momentum;
import com.vvvapps.momentum.entities.Objective;
import com.vvvapps.momentum.internal.ObjectiveViewAdapter;

import java.util.Arrays;

public class KeepMomentumActivity extends AppCompatActivity {

    public static final String TAG = KeepMomentumActivity.class.getName();

    // -- UI CONTAINERS --
    private Button planDayButton;
    private Button idStartMomentumButton;
    private TextView dayNumber;
    private ProgressBar momentumBar;
    private LinearLayout idStartMomentumLayout;
    private LinearLayout idMomentumBarLayout;
    private RecyclerView idRecyclerView;

    // -- DATABASE --
    private DatabaseConfig db;

    private Momentum currentMomentum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_momentum);

        //TODO: Get the active momentum from DB
        currentMomentum = new Momentum();
        currentMomentum.setActive(false);

        db = Room.databaseBuilder(getApplicationContext(), DatabaseConfig.class, "momentum-app-db").build();
        initUI();
    }


    private void initUI() {
        planDayButton = findViewById(R.id.idPlanADayButton);
        idStartMomentumButton = findViewById(R.id.idStartMomentumButton);
        dayNumber = findViewById(R.id.idDayNo);
        momentumBar = findViewById(R.id.idMomentumBar);
        idStartMomentumLayout = findViewById(R.id.idStartMomentumLayout);
        idMomentumBarLayout = findViewById(R.id.idMomentumBarLayout);
        idRecyclerView = findViewById(R.id.idRecyclerView);

        checkMomentumUI(currentMomentum);

        //TODO: Change adapter settings to take data from DB
        idRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Objective o1 = new Objective("Workout");
        Objective o2 = new Objective("Play with cat");
        Objective o3 = new Objective("Run like Forrest");
        idRecyclerView.setAdapter(new ObjectiveViewAdapter(Arrays.asList(o1, o2, o3)));
    }

    // -- UI Buttons Methods --
    public void planDayPress(View view) {
        Log.d(TAG, getString(R.string.plan_day) + " was pressed.");
    }

    public void startMomentumPress(View view) {
        Log.d(TAG, getString(R.string.start_momentum) + " was pressed.");
        currentMomentum.setActive(true);
        dayNumber.setText("1");
        checkMomentumUI(currentMomentum);
    }
    // -- UI Buttons Methods END --

    /**
     * Makes actions visible after Momentum started
     */
    private void checkMomentumUI(Momentum momentum) {
        if (momentum.isActive()) {
            momentumBar.setMax(100);
            idStartMomentumLayout.setVisibility(View.INVISIBLE);
            idMomentumBarLayout.setVisibility(View.VISIBLE);
            idRecyclerView.setVisibility(View.VISIBLE);
        } else {
            idStartMomentumLayout.setVisibility(View.VISIBLE);
            idMomentumBarLayout.setVisibility(View.INVISIBLE);
            idRecyclerView.setVisibility(View.INVISIBLE);
        }
    }

}