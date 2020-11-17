package com.vvvapps.momentum.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vvvapps.momentum.R;
import com.vvvapps.momentum.entities.ObjectiveDict;
import com.vvvapps.momentum.entities.relationship.ObjectiveAndDict;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which binds the {@link ObjectiveViewAdapter} to the {@link ObjectiveDict}
 */
public class ObjectiveViewAdapter extends RecyclerView.Adapter<ObjectiveViewAdapter.ObjectiveViewHolder> {

    private List<ObjectiveAndDict> objectives;
    private Context context;

    public ObjectiveViewAdapter(Context context, List<ObjectiveAndDict> objectives) {
        this.objectives = objectives;
        this.context = context;
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

        holder.getCheckBox().setText(objectives.get(position).getObjectiveDict().getDescription());
        holder.getCheckBox().setChecked(false);

        //TODO: Does this works? I select the correct item?
        holder.itemView.setOnClickListener(
                v -> {
                    ObjectiveAndDict o = objectives.get((int) getItemId(position));
                    Toast.makeText(context,
                                   String.format("id = %: %", o.getObjective().getObjectiveId(), o.getObjectiveDict().getDescription()),
                                   Toast.LENGTH_LONG
                    );
                }
        );
    }

    @Override
    public int getItemCount() {
        return objectives.size();
    }
}
