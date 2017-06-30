package com.example.workfit.DataFiles;
import android.app.usage.UsageStats;

import com.example.workfit.Activities.Home;

/**
 * Created by Revina Adisty on 6/26/2017.
 */

public class GlobalProgress_DynamicData {

    UsageStats stats;
    Home home;

    Integer _totalTimeSpent = (int) (long) (stats.getTotalTimeInForeground() / 1000) / 60;
    Integer _avgDuration = _totalTimeSpent/home.getTotalCount();

    public GlobalProgress_DynamicData() {

    }

    public Integer get_avgDuration(){
        return _avgDuration;
    }

    public Integer get_totalTimeSpent() {
        return _totalTimeSpent;
    }
}
