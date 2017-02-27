package com.example.yunalescca.swedishpronunciations.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;

/**
 * Created by Allex on 2016-12-08.
 */

public class Achievement {
    private String name;
    private int point;
    private Drawable picture;
    private String description;
    private boolean isAchieved;
    private SharedPreferences sharedPref;

    public Achievement(String name, int point, Drawable picture, String description, Context context){
        this.name=name;
        this.point=point;
        this.picture=picture;
        this.description=description;

        sharedPref = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        this.isAchieved = sharedPref.getBoolean(name, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAchieved() {
        return isAchieved;
    }

    public void setAchieved(boolean achieved) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(name, achieved);
        editor.apply();
        isAchieved = achieved;
    }

    public String toString(){
        return name;
    }

    public String getStatus() {
        if (isAchieved()){
            return "unlocked";
        }
        else {
            return "locked";
        }
    }
}
