package com.example.workfit.RecyclerViewStuffs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Revina Adisty on 7/1/2017.
 */

public class WorkoutChildItems implements Parcelable {

    private String name;
    private boolean isFavorite;

    public WorkoutChildItems(String name) {
        this.name = name;
        this.isFavorite = isFavorite;
    }

    protected WorkoutChildItems(Parcel in) {
        name = in.readString();
    }

    public String getName() {
        return name;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkoutChildItems)) return false;

        WorkoutChildItems workoutChildItems = (WorkoutChildItems) o;

        if (isFavorite() != workoutChildItems.isFavorite()) return false;
        return getName() != null ? getName().equals(workoutChildItems.getName()) : workoutChildItems.getName() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (isFavorite() ? 1 : 0);
        return result;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WorkoutChildItems> CREATOR = new Creator<WorkoutChildItems>() {
        @Override
        public WorkoutChildItems createFromParcel(Parcel in) {
            return new WorkoutChildItems(in);
        }

        @Override
        public WorkoutChildItems[] newArray(int size) {
            return new WorkoutChildItems[size];
        }
    };
}
