package com.example.workfit.DataFiles;

import android.content.Context;

import com.example.workfit.Activities.Home;
import com.example.workfit.DatabaseHandlers.DatabaseHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Revina Adisty on 6/1/2017.
 */

public class StatisticData {

    private List<String> StatisticListItems;
    private List<Integer> StatisticListResult;
    private String[][] ExpandListHeaders;
    private String[][][] ExpandListChild = new String[100][100][100];
    GlobalProgress_DynamicData globalProgressDynamicData;

    public StatisticData(Context context){
        StatisticListItems = new ArrayList<String>();
        StatisticListResult = new ArrayList<Integer>();
        ExpandListHeaders = new String[3][2];

        /** ini yang outer list tanpa anak **/
        StatisticListItems.add(0, "Average Duration");
        StatisticListItems.add(1, "Total Time");
        StatisticListItems.add(2, "Total Exercise Done");

        try {
            StatisticListResult.add(0, globalProgressDynamicData.get_avgDuration());
            StatisticListResult.add(1, globalProgressDynamicData.get_totalTimeSpent());
        } catch (NullPointerException e) {
            StatisticListResult.add(0, 0);
            StatisticListResult.add(1, 0);
        }
        /** ini kepala judul, anak dari Total Exercise Done **/        ExpandListHeaders[0][0] = "Abs Workout";
        ExpandListHeaders[1][0] = "Arm Workout";
        ExpandListHeaders[2][0] = "Butt Workout";



    }

    public String getStatListItem(int i) {
        return StatisticListItems.get(i);
    }

    public List<String> getFullStatList() {
        return StatisticListItems;
    }

    public Integer getStatResultItem(int i) {
        return StatisticListResult.get(i);
    }

    /**
     * SOLVED 11/6/2017 Pake SimpleAdapter >> Dibikin Map dulu trus dimasukin ke List
     * @param
     * @return
     */

    public String getHeaderName(int i) {
        return ExpandListHeaders[i][0];
    }

    public String getHeaderSubName(int pos, Context context) {
        DatabaseHandler db = new DatabaseHandler(context);
        DetailedProgress_DynamicData reps = db.getDatabase(pos);
        int temp = reps.getV0()+reps.getV1()+reps.getV2()+reps.getV3()+
                reps.getV4()+reps.getV5()+reps.getV6()+reps.getV7()+reps.getV8()+reps.getV9();
        ExpandListHeaders[pos][1] = String.valueOf(temp);
        return ExpandListHeaders[pos][1];
    }

    public String getChildItem(int groupIndex, int pos, int index) {
        return ExpandListChild[groupIndex][pos][index];
    }

    public List<Map<String,String>> getFullChildArray(int groupIndex) {
        List<Map<String, String>> child = new ArrayList<Map<String, String>>();
        Map<String, String> map;

        for(int i=0; ExpandListChild[groupIndex][i][0]==null; i++) {
            map = new HashMap<String, String>();
            map.put("child1", ExpandListChild[groupIndex][i][0]);
            map.put("child2", ExpandListChild[groupIndex][i][1]);
            child.add(map);
        }

        return child;
    }

    public Integer getChildLength(int groupIndex) {
        int i=0;
        while(ExpandListChild[groupIndex][i]!=null) {
            i++;
        }
        return (i-1);
    }

}