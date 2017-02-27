package com.example.yunalescca.swedishpronunciations.controllers;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import com.example.yunalescca.swedishpronunciations.*;
import com.example.yunalescca.swedishpronunciations.enums.AchievementId;
import com.example.yunalescca.swedishpronunciations.services.AchievementContainer;
import com.example.yunalescca.swedishpronunciations.services.AchievementHandler;
import com.example.yunalescca.swedishpronunciations.services.LetterContainer;

public class MainActivity extends Tools {

    private SharedPreferences preferenceSettings;
    private SharedPreferences.Editor preferenceEditor;
    private final static int PREFERENCE_MODE_PRIVATE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable background = findViewById(R.id.mainView).getBackground();
        background.setAlpha(80);


        //SHAREDPREFERENCES
        preferenceSettings = getPreferences(PREFERENCE_MODE_PRIVATE);
        preferenceEditor = preferenceSettings.edit();
        preferenceEditor.putString("apa", "apa");


        try {
            LetterContainer.getInstance().initContainer(this.getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            AchievementContainer.getInstance().initContainer(this.getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        AchievementHandler.getInstance().hasAchievement(this, AchievementId.WELCOME_ACHIEVEMENT);


    }
    public void vocalMenuGoTo(View v){
        Intent intent = new Intent(this, VowelMenuActivity.class);
        startActivity(intent);
    }
    public void aboutGoTo(View v){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }


    public void achievementListGoTo(View v){
        Intent intent = new Intent(this, AchievementListActivity.class);
        startActivity(intent);
    }


}

