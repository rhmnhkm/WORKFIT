package com.example.workfit.RecyclerViewStuffs;

import android.view.View;
import android.widget.TextView;

import com.example.workfit.workfitapps.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by Revina Adisty on 7/1/2017.
 */

public class HeaderViewHolder extends GroupViewHolder {

        private TextView genreTitle;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            genreTitle = (TextView)itemView.findViewById(R.id.list_item_genre_name);
        }

        public void setGenreTitle(ExpandableGroup group) {
            genreTitle.setText(group.getTitle());
        }

}