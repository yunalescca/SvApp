package com.example.yunalescca.swedishpronunciations.services;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yunalescca.swedishpronunciations.R;
import com.example.yunalescca.swedishpronunciations.enums.AchievementId;
import com.example.yunalescca.swedishpronunciations.models.*;

/**
 * Created by Allex on 2016-12-12.
 */

public class AchievementHandler{

    private static AchievementHandler instance;


    public static AchievementHandler getInstance(){
        if(instance == null){
            instance = new AchievementHandler();
        }
        return instance;
    }

    public void hasAchievement(Activity context, AchievementId id){
        if(id == null) {
        }
        else{
         instance.setAchievement(context, id);
            }
        }

    private void setAchievement(Activity context, AchievementId id) {
         if(AchievementContainer.getInstance().getAchievement(id).isAchieved()){
            }
         else{
             showAchievement(context, AchievementContainer.getInstance().getAchievement(id));
             AchievementContainer.getInstance().getAchievement(id).setAchieved(true);
            }
        }

    private void showAchievement(Activity context, Achievement achievement) {
        Toast toast;
         TextView name;
         TextView description;
         ImageView image;

        // get your custom_toast.xml ayout
        LayoutInflater inflater = (LayoutInflater) context.getLayoutInflater();

        View layout = inflater.inflate(R.layout.achievement_toast, (ViewGroup) context.findViewById(R.id.toast_layout_root));

        // set a message
        name = (TextView) layout.findViewById(R.id.toast_name);
        description = (TextView) layout.findViewById(R.id.toast_description);
        image = (ImageView) layout.findViewById(R.id.toast_img);
        toast = new Toast(context);
        toast.setGravity(Gravity.FILL_HORIZONTAL|Gravity.TOP, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        name.setText(achievement.getName());
        description.setText(achievement.getDescription());
        image.setImageDrawable(achievement.getPicture());
        toast.setView(layout);
        toast.show();
    }


    public void hasWordAchievement(FragmentActivity activity, Word word) {
        if( word == null){
         // do nothing
        }
        else{
            if(!AchievementContainer.getInstance().getAchievement(AchievementId.SOUND_ACHIEVEMENT).isAchieved()){
                showAchievement(activity, AchievementContainer.getInstance().getAchievement(AchievementId.SOUND_ACHIEVEMENT));
                AchievementContainer.getInstance().getAchievement(AchievementId.SOUND_ACHIEVEMENT).setAchieved(true);
            }
            String name = word.getName();
            switch (name){
                case "Åsna": if(AchievementContainer.getInstance().getAchievement(AchievementId.DONKEY_ACHIEVEMENT).isAchieved()){
                    break;
                      }
                    else {
                    showAchievement(activity, AchievementContainer.getInstance().getAchievement(AchievementId.DONKEY_ACHIEVEMENT));
                    AchievementContainer.getInstance().getAchievement(AchievementId.DONKEY_ACHIEVEMENT).setAchieved(true);
                    break;
                }
                    default:break;
            }
        }
    }
}
