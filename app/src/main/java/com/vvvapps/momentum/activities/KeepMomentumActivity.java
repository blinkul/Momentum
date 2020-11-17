package com.vvvapps.momentum.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vvvapps.momentum.entities.Day;
import com.vvvapps.momentum.entities.Objective;
import com.vvvapps.momentum.entities.ObjectiveDict;
import com.vvvapps.momentum.viewmodel.MomentumViewModel;
import com.vvvapps.momentum.R;
import com.vvvapps.momentum.adapter.ObjectiveViewAdapter;
import com.vvvapps.momentum.entities.Momentum;
import com.vvvapps.momentum.entities.relationship.ObjectiveAndDict;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


//TODO: At insert time of new momentum, function should set the previous momentum inactive and end date = LocalDate.now()
public class KeepMomentumActivity extends AppCompatActivity {

    public static final String TAG = KeepMomentumActivity.class.getName();

    // -- UI CONTAINERS --
    private Button planDayButton;
    private Button startMomentumButton;
    private TextView dayNoText;
    private ProgressBar momentumBar;
    private LinearLayout startMomentumLayout;
    private LinearLayout momentumBarLayout;
    private RecyclerView recyclerView;

    // -- Entities
    private Momentum momentum;

    // -- View Model for LiveData
    private MomentumViewModel model;
    private ExecutorService executor;
    private ObjectiveViewAdapter objectiveAdapter;
    private List<ObjectiveAndDict> objectiveAndDicts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_momentum);

        objectiveAndDicts = new ArrayList<>();
        objectiveAdapter = new ObjectiveViewAdapter(this, objectiveAndDicts);
        executor = Executors.newFixedThreadPool(4);

        initObserver();
        initComponentsAndUi();
        initButtonListeners();
        verifyUiBasedOnMomentumStatus();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.shutdown();
    }

    //start observing LiveData object
    private void initObserver() {
        model = new ViewModelProvider(this).get(MomentumViewModel.class);
        final Observer<Momentum> momentumObserver = momentum -> {
            //Update the UI
        };
        //Observe the LiveData
        model.getMutableLiveData().observe(this, momentumObserver);
    }

    private void initComponentsAndUi() {
        planDayButton = findViewById(R.id.comp_planDayButton);
        startMomentumButton = findViewById(R.id.comp_startMomentumButton);
        dayNoText = findViewById(R.id.comp_dayNoText);
        momentumBar = findViewById(R.id.comp_momentumBar);
        startMomentumLayout = findViewById(R.id.comp_startMomentumLayout);
        momentumBarLayout = findViewById(R.id.comp_momentumBarLayout);
        recyclerView = findViewById(R.id.comp_recyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(objectiveAdapter);

    }

    /*TODO: in thread:
       - adaug obiectivele in objectiveAndDicts
       - dupa executie / la final objectiveAdapter.notifyDataSetChanged()
     */


    /**
     * Makes actions visible after Momentum started
     */
    private void verifyUiBasedOnMomentumStatus() {
        try {
            Callable<Momentum> callable = () -> model.getActiveMomentum();
            Future<Momentum> future = executor.submit(callable);
            momentum = future.get();
        } catch (InterruptedException | ExecutionException e) {
            Toast.makeText(getApplicationContext(), "Could not retrieve momenum.", Toast.LENGTH_LONG);
        }


        if (momentum != null && momentum.isActive()) {
            momentumBar.setMax(100);
            startMomentumLayout.setVisibility(View.INVISIBLE);
            momentumBarLayout.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        } else {
            startMomentumLayout.setVisibility(View.VISIBLE);
            momentumBarLayout.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        }
    }

    private void initButtonListeners() {
        // Plan Day
        planDayButton.setOnClickListener(v -> Log.d(TAG, getString(R.string.plan_day) + " was pressed."));

        // Start Momentum
        startMomentumButton.setOnClickListener(v -> {
            Log.d(TAG, getString(R.string.start_momentum) + " was pressed.");
            executor.execute(() -> model.createMomentum());
            objectiveAndDicts.addAll(loadTestData());
            objectiveAdapter.notifyDataSetChanged();
            verifyUiBasedOnMomentumStatus();
        });

    }

    private List<ObjectiveAndDict> loadTestData() {
        ObjectiveDict d1 = new ObjectiveDict("Merg cu masina");
        ObjectiveDict d2 = new ObjectiveDict("Pup iubita");
        ObjectiveDict d3 = new ObjectiveDict("Spal putina");

        Day today = new Day(1, LocalDate.now());

        Objective o1 = new Objective(today.getDayId(), d1.getObjectiveDictId(), true);
        Objective o2 = new Objective(today.getDayId(), d2.getObjectiveDictId(), false);
        Objective o3 = new Objective(today.getDayId(), d3.getObjectiveDictId(), true);

        ObjectiveAndDict od1 = new ObjectiveAndDict();
        od1.setObjective(o1);
        od1.setObjectiveDict(d1);

        ObjectiveAndDict od2 = new ObjectiveAndDict();
        od2.setObjective(o2);
        od2.setObjectiveDict(d2);

        ObjectiveAndDict od3 = new ObjectiveAndDict();
        od3.setObjective(o3);
        od3.setObjectiveDict(d3);

        return Arrays.asList(od1, od2, od3);
    }

}