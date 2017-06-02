package com.example.workfit.DataFiles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Revina Adisty on 6/1/2017.
 */

public class StatisticData {
    private List<String> StatisticListItems;

    public StatisticData(){
        StatisticListItems = new ArrayList<String>();
        StatisticListItems.add(0, "Average Duration");
        StatisticListItems.add(1, "Total Time");
        StatisticListItems.add(2, "Total Exercise Done");
    }

    public String getStatListItem(int i) {
        return StatisticListItems.get(i);
    }

    public List<String> getFullStatList() {
        return StatisticListItems;
    }

}