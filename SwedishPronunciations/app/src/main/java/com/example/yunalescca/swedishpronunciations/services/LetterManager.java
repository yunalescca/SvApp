package com.example.yunalescca.swedishpronunciations.services;

import java.util.ArrayList;

import com.example.yunalescca.swedishpronunciations.enums.LetterID;
import com.example.yunalescca.swedishpronunciations.models.*;

/**
 * Created by Razzan on 2016-09-30.
 */

public class LetterManager {

    public static final int TYPE_VOWELS = 0;
    //public static final int TYPE_CONSONANT = 2;  -- for implementation of consonants
    public static final int TYPE_ALL = 2;

    private static LetterManager letterManager = null;

    private LetterManager(){}

    public static LetterManager getInstance(){
        if(letterManager == null){
            letterManager = new LetterManager();
        }
        return letterManager;
    }

    public ArrayList<Letter> getLetters(int type) {
        ArrayList<Letter> letters = new ArrayList<>();

        LetterID[] letterIDs;

        switch (type) {
            case TYPE_VOWELS:
                letterIDs = LetterID.getVowels();
                break;
            case TYPE_ALL:
                letterIDs = LetterID.values();
                break;
            default:
                letterIDs = LetterID.values();
                break;
        }

        for (LetterID id : letterIDs) {
            Letter letter = LetterContainer.getInstance().getLetter(id);
            if (letter != null) {
                letters.add(letter);
            }
        }

        return letters;
    }
}
