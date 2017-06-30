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
        /** ini kepala judul, anak dari Total Exercise Done **/
        ExpandListHeaders[0][0] = "Abs Workout";
        ExpandListHeaders[1][0] = "Arm Workout";
        ExpandListHeaders[2][0] = "Butt Workout";

        //==========================================================================================

        /** Child item untuk list pertama : Abs Workout **/
        ExpandListChild[0][0][0] = "Bicycle Crunches";
        ExpandListChild[0][1][0] = "Bridge";
        ExpandListChild[0][2][0] = "Bird Dog";
        ExpandListChild[0][3][0] = "Cobras";
        ExpandListChild[0][4][0] = "Abdominal Crunches";
        ExpandListChild[0][5][0] = "Reverse Crunches";
        ExpandListChild[0][6][0] = "Mountain Climber";
        ExpandListChild[0][7][0] = "One Leg Bridge";
        ExpandListChild[0][8][0] = "Two Leg Bridge";
        ExpandListChild[0][9][0] = "Three Leg Bridge";

        /** Fetching from database for Abs Workout**/
        /*DetailedProgress_DynamicData fetchData = new DetailedProgress_DynamicData();

        fetchData = db.getDatabase(0); //index abs workout = 0*/

        DatabaseHandler db = new DatabaseHandler(context);

        ExpandListChild[0][0][1] = String.valueOf(db.getDatabase(0).getV0());
        ExpandListChild[0][1][1] = String.valueOf(db.getDatabase(0).getV1());
        ExpandListChild[0][2][1] = String.valueOf(db.getDatabase(0).getV2());
        ExpandListChild[0][3][1] = String.valueOf(db.getDatabase(0).getV3());
        ExpandListChild[0][4][1] = String.valueOf(db.getDatabase(0).getV4());
        ExpandListChild[0][5][1] = String.valueOf(db.getDatabase(0).getV5());
        ExpandListChild[0][6][1] = String.valueOf(db.getDatabase(0).getV6());
        ExpandListChild[0][7][1] = String.valueOf(db.getDatabase(0).getV7());
        ExpandListChild[0][8][1] = String.valueOf(db.getDatabase(0).getV8());
        ExpandListChild[0][9][1] = String.valueOf(db.getDatabase(0).getV9());

        //==========================================================================================

        /** Child item untuk list kedua : Arm Workout **/
        ExpandListChild[1][0][0] = "Bicycle Crunches";
        ExpandListChild[1][1][0] = "Bridge";
        ExpandListChild[1][2][0] = "Bird Dog";
        ExpandListChild[1][3][0] = "Cobras";
        ExpandListChild[1][4][0] = "Abdominal Crunches";
        ExpandListChild[1][5][0] = "Reverse Crunches";
        ExpandListChild[1][6][0] = "Mountain Climber";
        ExpandListChild[1][7][0] = "One Leg Bridge";
        ExpandListChild[1][8][0] = "Two Leg Bridge";
        ExpandListChild[1][9][0] = "Three Leg Bridge";

        /** Fetching from database for Arm Workout**/
        /*fetchData = db.getDatabase(1); //index arm workout = 1*/

        ExpandListChild[1][0][1] = String.valueOf(db.getDatabase(1).getV0());
        ExpandListChild[1][1][1] = String.valueOf(db.getDatabase(1).getV1());
        ExpandListChild[1][2][1] = String.valueOf(db.getDatabase(1).getV2());
        ExpandListChild[1][3][1] = String.valueOf(db.getDatabase(1).getV3());
        ExpandListChild[1][4][1] = String.valueOf(db.getDatabase(1).getV4());
        ExpandListChild[1][5][1] = String.valueOf(db.getDatabase(1).getV5());
        ExpandListChild[1][6][1] = String.valueOf(db.getDatabase(1).getV6());
        ExpandListChild[1][7][1] = String.valueOf(db.getDatabase(1).getV7());
        ExpandListChild[1][8][1] = String.valueOf(db.getDatabase(1).getV8());
        ExpandListChild[1][9][1] = String.valueOf(db.getDatabase(1).getV9());

        //==========================================================================================

        /** Child item untuk list ketiga : Butt Workout **/
        ExpandListChild[2][0][0] = "Bicycle Crunches";
        ExpandListChild[2][1][0] = "Bridge";
        ExpandListChild[2][2][0] = "Bird Dog";
        ExpandListChild[2][3][0] = "Cobras";
        ExpandListChild[2][4][0] = "Abdominal Crunches";
        ExpandListChild[2][5][0] = "Reverse Crunches";
        ExpandListChild[2][6][0] = "Mountain Climber";
        ExpandListChild[2][7][0] = "One Leg Bridge";
        ExpandListChild[2][8][0] = "Two Leg Bridge";
        ExpandListChild[2][9][0] = "Three Leg Bridge";

        /** Fetching from database for Butt Workout**/
        /*fetchData = db.getDatabase(2); //index butt workout = 2*/

        ExpandListChild[2][0][1] = String.valueOf(db.getDatabase(2).getV0());
        ExpandListChild[2][1][1] = String.valueOf(db.getDatabase(2).getV1());
        ExpandListChild[2][2][1] = String.valueOf(db.getDatabase(2).getV2());
        ExpandListChild[2][3][1] = String.valueOf(db.getDatabase(2).getV3());
        ExpandListChild[2][4][1] = String.valueOf(db.getDatabase(2).getV4());
        ExpandListChild[2][5][1] = String.valueOf(db.getDatabase(2).getV5());
        ExpandListChild[2][6][1] = String.valueOf(db.getDatabase(2).getV6());
        ExpandListChild[2][7][1] = String.valueOf(db.getDatabase(2).getV7());
        ExpandListChild[2][8][1] = String.valueOf(db.getDatabase(2).getV8());
        ExpandListChild[2][9][1] = String.valueOf(db.getDatabase(2).getV9());

        //==========================================================================================

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