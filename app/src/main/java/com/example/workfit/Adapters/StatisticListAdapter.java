package com.example.workfit.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.workfit.DataFiles.StatisticData;
import com.example.workfit.RecyclerViewStuffs.HeaderAdapter;
import com.example.workfit.workfitapps.R;

import java.util.List;

import static com.example.workfit.RecyclerViewStuffs.HeaderAndChildDataFactory.makeWorkoutList;

/**
 * Created by Revina Adisty on 6/1/2017.
 */

public class StatisticListAdapter extends ArrayAdapter<String> {

    private StatisticData data;
    private Context context;
    public HeaderAdapter adapter;

    public StatisticListAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.data = new StatisticData(context);
        this.context = context;
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

                RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recycler_view);
                LinearLayoutManager layoutManager = new LinearLayoutManager(context);

                adapter = new HeaderAdapter(makeWorkoutList());


                if (statListLast != null) {
                    statListLast.setText(p);

                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }
            }
        }

        return v;
    }






}
