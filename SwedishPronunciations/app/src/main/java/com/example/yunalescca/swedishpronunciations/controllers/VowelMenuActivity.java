package com.example.yunalescca.swedishpronunciations.controllers;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import java.util.ArrayList;

import com.example.yunalescca.swedishpronunciations.services.AchievementHandler;
import com.example.yunalescca.swedishpronunciations.enums.AchievementId;
import com.example.yunalescca.swedishpronunciations.LetterFragment;
import com.example.yunalescca.swedishpronunciations.services.LetterManager;
import com.example.yunalescca.swedishpronunciations.R;
import com.example.yunalescca.swedishpronunciations.models.*;


public class VowelMenuActivity extends Tools {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vowel_menu);

        Drawable background = findViewById(R.id.activity_vowel_menu).getBackground();
        background.setAlpha(60);

        ArrayList<String> letterNames = new ArrayList<>();
        for (Letter letter : LetterManager.getInstance().getLetters(LetterManager.TYPE_VOWELS)) {
            letterNames.add(letter.getLetter().toUpperCase() + letter.getLetter());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.letter_grid_item, letterNames);
        GridView vowelMenu = (GridView) findViewById(R.id.vowel_menu_gridview);
        vowelMenu.setAdapter(adapter);

        vowelMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putInt(LetterFragment.ARG_LETTER_POSITION, i);
                bundle.putInt(LetterFragment.ARG_LETTER_TYPE, LetterManager.TYPE_VOWELS);
                Intent intent = new Intent(VowelMenuActivity.this, LetterActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
        AchievementHandler.getInstance().hasAchievement(this, AchievementId.VOWELS_ACHIEVEMENT);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}