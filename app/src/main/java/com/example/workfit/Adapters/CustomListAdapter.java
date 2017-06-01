package com.example.workfit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.workfit.DataFiles.StatisticData;
import com.example.workfit.workfitapps.R;

import java.util.List;

/**
 * Created by Revina Adisty on 6/1/2017.
 */

public class CustomListAdapter extends ArrayAdapter<String> {

    StatisticData data = new StatisticData();


    public CustomListAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
    }

    @Override //Ini buat nampilin per row dari String[]ListDepartemen ke XML Layout list_items
    public View getView(int position, View convertView, ViewGroup Parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            v = layoutInflater.inflate(R.layout.statistic_list_items, null);
        }

        String p = data.getStatListItem(position);

        if (p!=null) {
            TextView NamaDepartemen = (TextView)v.findViewById(R.id.statList);

            if (NamaDepartemen != null) {
                NamaDepartemen.setText(p);
            }
        }

        return v;
    }

}
