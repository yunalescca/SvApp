package com.example.yunalescca.swedishpronunciations.models;

import android.graphics.drawable.Drawable;

import com.example.yunalescca.swedishpronunciations.enums.WordType;

/**
 * Created by Emilia on 2016-10-05.
 */

public class Word {
    private Drawable picture;
    private String name;
    private WordType type;

    public Word(String name, Drawable picture, WordType type) {
        this.name = name;
        this.picture = picture;
        this.type = type;
    }

    public Drawable getPicture() {
        return picture;
    }

    public String getName() {
        return name;
    }

    public WordType getType() {
        return type;
    }
}
