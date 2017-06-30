package com.example.workfit.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.workfit.Activities.Home;
import com.example.workfit.Activities.Register;
import com.example.workfit.Adapters.StatisticListAdapter;
import com.example.workfit.DataFiles.DetailedProgress_DynamicData;
import com.example.workfit.DataFiles.StatisticData;
import com.example.workfit.DatabaseHandlers.DatabaseHandler;
import com.example.workfit.workfitapps.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatisticFragment extends Fragment {


    public StatisticFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistic, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List();
    }

    public void List(){

        /** Generating the list **/
        StatisticData data = new StatisticData(getActivity());
        StatisticListAdapter customAdapter = new StatisticListAdapter(getActivity(), R.layout.statistic_list_items, data.getFullStatList());
        ListView StatisticList = (ListView)getView().findViewById(R.id.statisticListView);
        StatisticList.setAdapter(customAdapter);
        StatisticList.setClickable(true);
    }

}
