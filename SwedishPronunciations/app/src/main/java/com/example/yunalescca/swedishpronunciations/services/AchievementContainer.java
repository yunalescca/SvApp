package com.example.yunalescca.swedishpronunciations.services;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.yunalescca.swedishpronunciations.enums.AchievementId;
import com.example.yunalescca.swedishpronunciations.R;
import com.example.yunalescca.swedishpronunciations.models.*;

/**
 * Created by Allex on 2016-12-08.
 */

public class AchievementContainer {


    private HashMap<AchievementId, Achievement> achievementContainer;

    private static AchievementContainer instance;
    private boolean isInitiated;

    private AchievementContainer(){
        isInitiated=false;

    }

    public static AchievementContainer getInstance(){
        if(instance == null){
            instance = new AchievementContainer();
        }
        return instance;
    }
    public void initContainer(Context context){
        if(isInitiated==false) {

            isInitiated=true;

            achievementContainer = new HashMap<>();

            achievementContainer.put(AchievementId.DONKEY_ACHIEVEMENT,
                    new Achievement("Donkey", 100, context.getDrawable(R.drawable.asna_achievement), "You have found a donkey", context));
            achievementContainer.put(AchievementId.VOWELS_ACHIEVEMENT,
                    new Achievement("Vowels", 50, context.getDrawable(R.drawable.vowels_achievement), "You have found the vowels", context));
            achievementContainer.put(AchievementId.WELCOME_ACHIEVEMENT,
                    new Achievement("Welcome", 50, context.getDrawable(R.drawable.welcome_achievement), "Welcome to this application", context));
            achievementContainer.put(AchievementId.FIFTY_ACHIEVEMENT,
                    new Achievement("50%", 50, context.getDrawable(R.drawable.gris), "You have listened to 50% of the vowels", context));
            achievementContainer.put(AchievementId.SOUND_ACHIEVEMENT,
                    new Achievement("AH, it makes sound", 50, context.getDrawable(R.drawable.sound_achievement), "You have listened to your first sound", context));
        } else {
            //do nothing
        }
    }

    public ArrayList<Achievement> getAchievements() {
        return new ArrayList<Achievement>(achievementContainer.values());
    }

    public Achievement getAchievement(AchievementId id){
        return achievementContainer.get(id);
    }

    public Achievement getAchievement(String name){
        for ( Achievement achievement: achievementContainer.values()){
            if (name.equals(achievement.getName())){
                return achievement;
            }
        }
        return null;
    }
}
