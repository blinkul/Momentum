package com.vvvapps.momentum.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.vvvapps.momentum.database.DatabaseConfig;
import com.vvvapps.momentum.entities.Momentum;
import com.vvvapps.momentum.repository.DatabaseRepository;


/**
 * Class that store LiveData objects that update the UI.
 * Use this instead of activity to store data.
 *
 * https://developer.android.com/topic/libraries/architecture/livedata
 */
public class MomentumViewModel extends AndroidViewModel {

    private DatabaseRepository repository;
    private MutableLiveData<Momentum> mutableLiveData;

    public MomentumViewModel(@NonNull Application application) {
        super(application);
        repository = DatabaseRepository.getConnection(
                Room.databaseBuilder(application.getApplicationContext(),
                        DatabaseConfig.class, "momentum-app-db")
                .build());
    }

    public MutableLiveData<Momentum> getMutableLiveData() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
        }
        return mutableLiveData;
    }

    // == MOMENTUM METHODS ==
    public void createMomentum() {
        repository.createNewMomentum();
    }

    public Momentum getActiveMomentum() {
        return repository.getActiveMomentum();
    }

    // == DAY METHODS ==



    // == OBJECTIVES METHODS ==



    // == OBJECTIVES DICT METHODS ==


}
