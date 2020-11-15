package com.vvvapps.momentum.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vvvapps.momentum.R;
import com.vvvapps.momentum.entities.Objective;

import java.util.List;

/**
 * Class which binds the {@link ObjectiveViewAdapter} to the {@link com.vvvapps.momentum.entities.Objective}
 */
public class ObjectiveViewAdapter extends RecyclerView.Adapter<ObjectiveViewAdapter.ObjectiveViewHolder> {

    private List<Objective> objectives;

    public ObjectiveViewAdapter(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public class ObjectiveViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox checkBox;

        public ObjectiveViewHolder(@NonNull View itemView) {
            super(itemView);
            //Define click listener for the ViewHolder's view
            checkBox = itemView.findViewById(R.id.idCheckBox);
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }
    }

    @NonNull
    @Override
    public ObjectiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.objective_item_layout, parent, false);
        return new ObjectiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjectiveViewHolder holder, int position) {
        //TODO: How do I know which objective is done for a Day
        holder.getCheckBox().setText(objectives.get(position).getDescription());
        holder.getCheckBox().setChecked(false);
    }

    @Override
    public int getItemCount() {
        return objectives.size();
    }
}
