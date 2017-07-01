package com.example.workfit.RecyclerViewStuffs;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Revina Adisty on 7/1/2017.
 */

public class WorkoutHeaderItems extends ExpandableGroup<WorkoutChildItems> {

    private int iconResId;

    public WorkoutHeaderItems(String title, List<WorkoutChildItems> items) {
        super(title, items);
    }
}