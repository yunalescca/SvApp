package com.example.yunalescca.swedishpronunciations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.yunalescca.swedishpronunciations.enums.SoundType;
import com.example.yunalescca.swedishpronunciations.models.*;
import com.example.yunalescca.swedishpronunciations.services.AchievementHandler;
import com.example.yunalescca.swedishpronunciations.services.LetterManager;

import java.util.ArrayList;

/**
 * Created by tove on 2016-09-25.
 */

public class LetterFragment extends Fragment implements View.OnClickListener {

    public static final String ARG_LETTER_POSITION = "letter_position";
    public static final String ARG_LETTER_TYPE = "letter_type";

    private ImageButton imageButtonShort1;
    private ImageButton imageButtonShort2;
    private ImageButton imageButtonShort3;
    private ImageButton imageButtonLong1;
    private ImageButton imageButtonLong2;
    private ImageButton imageButtonLong3;
    private Button buttonLongVowel, buttonShortVowel;
    private TextView titleText;
    private Letter letter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_letter, container, false);

        Bundle args = getArguments();
        int position = args.getInt(ARG_LETTER_POSITION);
        int letterType = args.getInt(ARG_LETTER_TYPE);

        ArrayList<Letter> letters = LetterManager.getInstance().getLetters(letterType);
        Letter letter = letters.get(position);

        init(view);
        updateViewWithLetter(letter);

        return view;
    }

    private void init(View view) {

        imageButtonShort1 = (ImageButton) view.findViewById(R.id.imageButtonShort1);
        imageButtonShort2 = (ImageButton) view.findViewById(R.id.imageButtonShort2);
        imageButtonShort3 = (ImageButton) view.findViewById(R.id.imageButtonShort3);
        imageButtonLong1 = (ImageButton) view.findViewById(R.id.imageButtonLong1);
        imageButtonLong2 = (ImageButton) view.findViewById(R.id.imageButtonLong2);
        imageButtonLong3 = (ImageButton) view.findViewById(R.id.imageButtonLong3);

        buttonShortVowel = (Button) view.findViewById(R.id.buttonShortVowel);
        buttonLongVowel = (Button) view.findViewById(R.id.buttonLongVowel);

        titleText = (TextView) view.findViewById(R.id.titleText);
    }

    private void updateViewWithLetter(final Letter letter) {
        this.letter = letter;
        //check if vowel here
        if (letter.getWordsLong() != null) {

            titleText.setText(letter.getLetter().toUpperCase() + letter.getLetter().toLowerCase());
            buttonShortVowel.setText("[ " + letter.getLetter() + " ]");
            buttonLongVowel.setText("[ " + letter.getLetter() + ": ]");

            buttonShortVowel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    letter.getSoundPlayer().play(SoundType.SHORT_VOWEL_SOUND);
                }
            });

            buttonLongVowel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    letter.getSoundPlayer().play(SoundType.LONG_VOWEL_SOUND);
                }
            });


            imageButtonShort1.setImageDrawable(letter.getWordsShort().get(0).getPicture());
            imageButtonShort2.setImageDrawable(letter.getWordsShort().get(1).getPicture());
            imageButtonShort3.setImageDrawable(letter.getWordsShort().get(2).getPicture());
            imageButtonLong1.setImageDrawable(letter.getWordsLong().get(0).getPicture());
            imageButtonLong2.setImageDrawable(letter.getWordsLong().get(1).getPicture());
            imageButtonLong3.setImageDrawable(letter.getWordsLong().get(2).getPicture());

            imageButtonShort1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    letter.getSoundPlayer().play(SoundType.SHORT_VOWEL_WORD1);
                    hasAchievement(SoundType.SHORT_VOWEL_WORD1);
                }
            });

            imageButtonShort2.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                    letter.getSoundPlayer().play(SoundType.SHORT_VOWEL_WORD2);
                     hasAchievement(SoundType.SHORT_VOWEL_WORD2);
                }
             });

         imageButtonShort3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 letter.getSoundPlayer().play(SoundType.SHORT_VOWEL_WORD3);
                 hasAchievement(SoundType.SHORT_VOWEL_WORD3);
             }
         });

         imageButtonLong1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 letter.getSoundPlayer().play(SoundType.LONG_VOWEL_WORD1);
                 hasAchievement(SoundType.LONG_VOWEL_WORD1);
             }
         });
         imageButtonLong2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 letter.getSoundPlayer().play(SoundType.LONG_VOWEL_WORD2);
                 hasAchievement(SoundType.LONG_VOWEL_WORD2);
             }
         });
         imageButtonLong3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 letter.getSoundPlayer().play(SoundType.LONG_VOWEL_WORD3);
                 hasAchievement(SoundType.LONG_VOWEL_WORD3);
             }
         });

        }
    }

    private void hasAchievement(SoundType type) {
        Word word = null;
        switch (type){
            case SHORT_VOWEL_WORD1: word=letter.getWordsShort().get(0); break;
            case SHORT_VOWEL_WORD2: word=letter.getWordsShort().get(1); break;
            case SHORT_VOWEL_WORD3: word=letter.getWordsShort().get(2); break;
            case LONG_VOWEL_WORD1:  word=letter.getWordsLong().get(0); break;
            case LONG_VOWEL_WORD2:  word=letter.getWordsLong().get(1); break;
            case LONG_VOWEL_WORD3:  word=letter.getWordsLong().get(2); break;
            default: break;
        }
        AchievementHandler.getInstance().hasWordAchievement(this.getActivity(), word);

    }

    @Override
    public void onClick(View v) {}

}