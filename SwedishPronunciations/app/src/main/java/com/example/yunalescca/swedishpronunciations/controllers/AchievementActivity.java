package com.example.yunalescca.swedishpronunciations.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.yunalescca.swedishpronunciations.*;
import com.example.yunalescca.swedishpronunciations.models.*;
import com.example.yunalescca.swedishpronunciations.services.AchievementContainer;

public class AchievementActivity extends AppCompatActivity {
    private TextView name;
    private TextView point;
    private TextView status;
    private TextView description;
    private ImageView image;
    private Achievement achievement;
    public static final String ARG_ACHIEVEMENT_POSITION = "achievement_position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        Bundle args = getIntent().getExtras();
        if (args != null) {
            achievement = AchievementContainer.getInstance().getAchievement(args.getString(ARG_ACHIEVEMENT_POSITION));
            updateViewWithAchievement();
        }


    }

    private void updateViewWithAchievement() {
        name = (TextView) findViewById(R.id.achievement_name);
        description = (TextView) findViewById(R.id.achievement_description);
        status = (TextView) findViewById(R.id.achievement_status);
        point = (TextView) findViewById(R.id.achievement_point);
        image = (ImageView) findViewById(R.id.achievement_image);
        name.setText(achievement.getName());
        point.setText("points: " +Integer.toString(achievement.getPoint()));
        description.setText(achievement.getDescription());
        status.setText(achievement.getStatus());
        image.setImageDrawable(achievement.getPicture());
    }
}
