package com.example.workfit.RecyclerViewStuffs;

import android.view.View;
import android.widget.TextView;

import com.example.workfit.workfitapps.R;


/**
 * Created by Revina Adisty on 7/1/2017.
 */

public class ChildViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {

    private TextView childTextView;

    public ChildViewHolder(View itemView) {
        super(itemView);
        childTextView = (TextView) itemView.findViewById(R.id.child1);
    }

    public void setArtistName(String name) {
        childTextView.setText(name);
    }
}