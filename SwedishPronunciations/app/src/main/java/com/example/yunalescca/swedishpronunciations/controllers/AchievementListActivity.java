package com.example.yunalescca.swedishpronunciations.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.app.Activity;
import com.example.yunalescca.swedishpronunciations.*;
import com.example.yunalescca.swedishpronunciations.models.*;

import com.example.yunalescca.swedishpronunciations.R;
import com.example.yunalescca.swedishpronunciations.services.AchievementContainer;

import java.util.ArrayList;


public class AchievementListActivity extends Activity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_list);

        final ArrayList<Achievement> achievements = AchievementContainer.getInstance().getAchievements();


        CustomList adapter = new
                CustomList(AchievementListActivity.this, achievements);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Bundle bundle = new Bundle();
                bundle.putString(AchievementActivity.ARG_ACHIEVEMENT_POSITION, parent.getAdapter().getItem(position).toString());
                Intent intent = new Intent(AchievementListActivity.this, AchievementActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });




    }

}

