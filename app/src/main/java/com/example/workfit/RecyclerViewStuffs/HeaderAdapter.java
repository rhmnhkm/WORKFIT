package com.example.workfit.RecyclerViewStuffs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.workfit.workfitapps.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Revina Adisty on 7/1/2017.
 */

public class HeaderAdapter extends ExpandableRecyclerViewAdapter<HeaderViewHolder, ChildViewHolder> {

    public HeaderAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public HeaderViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.statistic_list_group_header_items, parent, false);
        return new HeaderViewHolder(view);
    }

    @Override
    public ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.statistic_list_group_child_items, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int flatPosition,
                                      ExpandableGroup group, int childIndex) {

        final WorkoutChildItems workoutChildItems = ((WorkoutHeaderItems) group).getItems().get(childIndex);
        holder.setArtistName(workoutChildItems.getName());
    }

    @Override
    public void onBindGroupViewHolder(HeaderViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {

        holder.setGenreTitle(group);
    }
}