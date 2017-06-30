package com.example.workfit.DataFiles;

/**
 * Created by Revina Adisty on 6/27/2017.
 */

public class PersonalData {
    private String name;
    private int height;
    private int weight;
    private boolean gender;

    public PersonalData(String name, boolean gender, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setGender(int gender) {
        Boolean genderBoolean;
        if(gender==1) {
            genderBoolean = true;
        } else genderBoolean = false;
        this.gender = genderBoolean;
    }
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
    public void setWeight (int newWeight) {
        this.weight = newWeight;
    }

    public String getName() {
        return this.name;
    }
    public int getGender() {
        if(this.gender) {
            return 1;
        } else return 0;
    }
    public int getHeight() {
        return this.height;
    }
    public int getWeight() {
        return this.weight;
    }

}
