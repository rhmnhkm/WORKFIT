package com.example.workfit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.workfit.DataFiles.StatisticData;
import com.example.workfit.workfitapps.R;

import java.util.List;

/**
 * Created by Revina Adisty on 6/1/2017.
 */

public class StatisticListAdapter extends ArrayAdapter<String> {

    private StatisticData data;

    public StatisticListAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
         this.data = new StatisticData(context);
    }

    @Override //Ini buat nampilin per row dari String[]ListDepartemen ke XML Layout list_items
    public View getView(int position, View convertView, ViewGroup Parent) {

        View v = convertView;

        if(position != 2) { //Jika posisi bukan list item yang terakhir, generate biasa

            if (v == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(getContext());
                v = layoutInflater.inflate(R.layout.statistic_list_items, null);
            }

            String p = data.getStatListItem(position);
            Integer r = data.getStatResultItem(position);

            if (p != null && r != null) {
                TextView statList = (TextView) v.findViewById(R.id.statList);
                TextView statRes = (TextView) v.findViewById(R.id.statResult);

                if (statList != null) {
                    statList.setText(p);
                    statRes.setText(String.valueOf(r));
                }
            }
        } else { //jika list item terakhir, bikin yang berbeda

            if (v == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(getContext());
                v = layoutInflater.inflate(R.layout.statistic_list_lastitems, null);
            }

            String p = data.getStatListItem(position);

            if (p != null) {
                TextView statListLast = (TextView) v.findViewById(R.id.lastItem);
                ExpandableListView expandedStatList = (ExpandableListView)v.findViewById(R.id.expandedListView);

                if (statListLast != null) {
                    statListLast.setText(p);
                    /**
                     * set adapter expandlist make adapter yang lagi dibuat.
                     * onclicklistenernya ditaro di adapter yang satu lagi aja, tugas adapter yang ini
                     * cuma nampilin textview sama expandablelistview.
                     */
                    StatisticExpandedListAdapter statisticExpandedListAdapter = new StatisticExpandedListAdapter();
                    expandedStatList.setAdapter(statisticExpandedListAdapter);
                }
            }
        }

        return v;
    }






}
