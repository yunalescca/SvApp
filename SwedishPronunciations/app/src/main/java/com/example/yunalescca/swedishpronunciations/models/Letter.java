package com.example.yunalescca.swedishpronunciations.models;

import java.util.ArrayList;

import com.example.yunalescca.swedishpronunciations.enums.WordType;

/**
 * Created by Allex on 2016-09-22.
 */
public class Letter {

    private String letter;
    private SoundPlayer sound;
    private ArrayList<Word> wordsLong;
    private ArrayList<Word> wordsShort;

    public Letter(String letter, SoundPlayer sound, ArrayList<Word> words){
        this.letter = letter;
        this.sound = sound;
        this.wordsLong = new ArrayList<>();
        this.wordsShort = new ArrayList<>();
        checkWords(words);
    }

    private void checkWords(ArrayList<Word> words) {
        for (int i = 0; i < words.size(); i++){
            if (words.get(i).getType() == WordType.LONG){
                wordsLong.add(words.get(i));
            } else if (words.get(i).getType() == WordType.SHORT){
                wordsShort.add(words.get(i));
            }
        }
    }

    public String getLetter() {
        return letter;
    }

    public SoundPlayer getSoundPlayer(){
        return this.sound;
    }

    public ArrayList<Word> getWordsShort() {
        return wordsShort;
    }

    public ArrayList<Word> getWordsLong() {
        return wordsLong;

    }

}
