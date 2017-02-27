package com.example.yunalescca.swedishpronunciations.models;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;

import com.example.yunalescca.swedishpronunciations.enums.LetterType;
import com.example.yunalescca.swedishpronunciations.enums.SoundType;

import java.util.HashMap;

public class SoundPlayer {

    private SoundPool soundPool;
    private SoundPool.Builder soundPoolBuilder;
    private AudioAttributes audioAttributes;
    private AudioAttributes.Builder audioAttributesBuilder;

    private HashMap<SoundType, Integer> soundPoolIDs;

    public SoundPlayer(Context context, LetterType letterType, HashMap<SoundType, Integer> soundRawIDs){

        audioAttributesBuilder=new AudioAttributes.Builder();
        audioAttributesBuilder.setUsage(AudioAttributes.USAGE_MEDIA);
        audioAttributesBuilder.setContentType(AudioAttributes.CONTENT_TYPE_SPEECH);

        audioAttributes=audioAttributesBuilder.build();

        soundPoolBuilder=new SoundPool.Builder();
        soundPoolBuilder.setAudioAttributes(audioAttributes);
        soundPool=soundPoolBuilder.build();

        soundPoolIDs=new HashMap<>();

        if(letterType==LetterType.VOWEL) {
            soundPoolIDs.put(SoundType.SHORT_VOWEL_SOUND, soundPool.load(context, soundRawIDs.get(SoundType.SHORT_VOWEL_SOUND), 1));
            soundPoolIDs.put(SoundType.LONG_VOWEL_SOUND, soundPool.load(context, soundRawIDs.get(SoundType.LONG_VOWEL_SOUND), 1));

            soundPoolIDs.put(SoundType.SHORT_VOWEL_WORD1, soundPool.load(context, soundRawIDs.get(SoundType.SHORT_VOWEL_WORD1), 1));
            soundPoolIDs.put(SoundType.SHORT_VOWEL_WORD2, soundPool.load(context, soundRawIDs.get(SoundType.SHORT_VOWEL_WORD2), 1));
            soundPoolIDs.put(SoundType.SHORT_VOWEL_WORD3, soundPool.load(context, soundRawIDs.get(SoundType.SHORT_VOWEL_WORD3), 1));
            soundPoolIDs.put(SoundType.LONG_VOWEL_WORD1, soundPool.load(context, soundRawIDs.get(SoundType.LONG_VOWEL_WORD1), 1));
            soundPoolIDs.put(SoundType.LONG_VOWEL_WORD2, soundPool.load(context, soundRawIDs.get(SoundType.LONG_VOWEL_WORD2), 1));
            soundPoolIDs.put(SoundType.LONG_VOWEL_WORD3, soundPool.load(context, soundRawIDs.get(SoundType.LONG_VOWEL_WORD3), 1));

        } else if (letterType==LetterType.LETTER_COMBINATION||letterType==LetterType.CONSONANT){

            soundPoolIDs.put(SoundType.OTHERS_WORD1, soundPool.load(context, soundRawIDs.get(SoundType.OTHERS_WORD1), 1));
            soundPoolIDs.put(SoundType.OTHERS_WORD2, soundPool.load(context, soundRawIDs.get(SoundType.OTHERS_WORD2), 1));
            soundPoolIDs.put(SoundType.OTHERS_WORD3, soundPool.load(context, soundRawIDs.get(SoundType.OTHERS_WORD3), 1));

            soundPoolIDs.put(SoundType.OTHERS_MAIN_SOUND, soundPool.load(context, soundRawIDs.get(SoundType.OTHERS_MAIN_SOUND), 1));
        }
    }

    //add this to a play button click method
    public void play(SoundType soundType){
        soundPool.play(soundPoolIDs.get(soundType),1,1,1,0,1f);
    }


    //add this to a stop button click method
    public void stop(SoundType soundType){
        int streamId = soundPool.play(soundPoolIDs.get(soundType),1,1,0,0,1.0f);
        soundPool.stop(streamId);
    }
}

