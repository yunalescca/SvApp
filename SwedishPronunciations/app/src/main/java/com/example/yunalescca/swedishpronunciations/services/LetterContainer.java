package com.example.yunalescca.swedishpronunciations.services;

import android.content.Context;

import com.example.yunalescca.swedishpronunciations.enums.LetterID;
import com.example.yunalescca.swedishpronunciations.enums.LetterType;
import com.example.yunalescca.swedishpronunciations.R;
import com.example.yunalescca.swedishpronunciations.enums.SoundType;
import com.example.yunalescca.swedishpronunciations.enums.WordType;
import com.example.yunalescca.swedishpronunciations.models.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Lina on 2016-09-30.
 */

public class LetterContainer {

    private HashMap<LetterID, Letter> letterContainer;

    private static LetterContainer instance;
    private boolean isInitiated;

    private LetterContainer(){
        isInitiated=false;
    }

    public static LetterContainer getInstance(){
        if(instance == null){
            instance = new LetterContainer();
        }
        return instance;
    }

    public void initContainer(Context context){
        if(isInitiated==false) {

            isInitiated=true;

            letterContainer = new HashMap<>();

            ///--------A--------
            HashMap<SoundType, Integer> soundRawIDs = new HashMap<>();
            soundRawIDs.put(SoundType.LONG_VOWEL_SOUND, R.raw.vowel_a_long);
            soundRawIDs.put(SoundType.SHORT_VOWEL_SOUND, R.raw.vowel_a_short);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD1, R.raw.vowel_a_long_glas);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD2, R.raw.vowel_a_long_fat);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD3, R.raw.vowel_a_long_sadel);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD1, R.raw.vowel_a_short_masker);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD2, R.raw.vowel_a_short_hatt);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD3, R.raw.vowel_a_short_lampa);

            ArrayList<Word> words = new ArrayList<>();
            //Långa uttal
            words.add(new Word("Glas", context.getDrawable(R.drawable.glas), WordType.LONG));
            words.add(new Word("Fat", context.getDrawable(R.drawable.fat), WordType.LONG));
            words.add(new Word("Sadel", context.getDrawable(R.drawable.sadel), WordType.LONG));
            //Korta uttal
            words.add(new Word("Masker", context.getDrawable(R.drawable.masker), WordType.SHORT));
            words.add(new Word("Hatt", context.getDrawable(R.drawable.hatt), WordType.SHORT));
            words.add(new Word("Lampa", context.getDrawable(R.drawable.lampa), WordType.SHORT));

            letterContainer.put(LetterID.A_LETTER,
                    new Letter("a", new SoundPlayer(context, LetterType.VOWEL, soundRawIDs), words));


            ///--------E--------
            soundRawIDs.clear();
            soundRawIDs.put(SoundType.LONG_VOWEL_SOUND, R.raw.vowel_e_long);
            soundRawIDs.put(SoundType.SHORT_VOWEL_SOUND, R.raw.vowel_e_short);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD1, R.raw.vowel_e_long_ben);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD2, R.raw.vowel_e_long_tre);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD3, R.raw.vowel_e_long_ren);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD1, R.raw.vowel_e_short_elefant);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD2, R.raw.vowel_e_short_fem);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD3, R.raw.vowel_e_short_sex);

            words.clear();
            //Långa uttal
            words.add(new Word("Ben", context.getDrawable(R.drawable.ben), WordType.LONG));
            words.add(new Word("Tre", context.getDrawable(R.drawable.tre), WordType.LONG));
            words.add(new Word("Ren", context.getDrawable(R.drawable.ren), WordType.LONG));
            //Korta uttal
            words.add(new Word("Elefant", context.getDrawable(R.drawable.elefant), WordType.SHORT));
            words.add(new Word("Fem", context.getDrawable(R.drawable.fem), WordType.SHORT));
            words.add(new Word("Sex", context.getDrawable(R.drawable.sex), WordType.SHORT));

            letterContainer.put(LetterID.E_LETTER,
                    new Letter("e", new SoundPlayer(context, LetterType.VOWEL, soundRawIDs), words));


            ///--------I--------
            soundRawIDs.clear();
            soundRawIDs.put(SoundType.LONG_VOWEL_SOUND, R.raw.vowel_i_long);
            soundRawIDs.put(SoundType.SHORT_VOWEL_SOUND, R.raw.vowel_i_short);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD1, R.raw.vowel_i_long_bil);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD2, R.raw.vowel_i_long_pil);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD3, R.raw.vowel_i_long_gris);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD1, R.raw.vowel_i_short_fisk);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD2, R.raw.vowel_i_short_slips);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD3, R.raw.vowel_i_short_ring);

            words.clear();
            //Långa uttal
            words.add(new Word("Bil", context.getDrawable(R.drawable.bil), WordType.LONG));
            words.add(new Word("Pil", context.getDrawable(R.drawable.pil), WordType.LONG));
            words.add(new Word("Gris", context.getDrawable(R.drawable.gris), WordType.LONG));
            //Korta uttal
            words.add(new Word("Fisk", context.getDrawable(R.drawable.fisk), WordType.SHORT));
            words.add(new Word("Slips", context.getDrawable(R.drawable.slips), WordType.SHORT));
            words.add(new Word("Ring", context.getDrawable(R.drawable.ring), WordType.SHORT));

            letterContainer.put(LetterID.I_LETTER,
                    new Letter("i", new SoundPlayer(context, LetterType.VOWEL, soundRawIDs), words));


            ///--------O--------
            soundRawIDs.clear();
            soundRawIDs.put(SoundType.LONG_VOWEL_SOUND, R.raw.vowel_o_long);
            soundRawIDs.put(SoundType.SHORT_VOWEL_SOUND, R.raw.vowel_o_short);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD1, R.raw.vowel_o_long_sol);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD2, R.raw.vowel_o_long_stol);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD3, R.raw.vowel_o_long_ko);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD1, R.raw.vowel_o_short_korv);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD2, R.raw.vowel_o_short_klocka);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD3, R.raw.vowel_o_short_bock);

            words.clear();
            //Långa uttal
            words.add(new Word("Sol", context.getDrawable(R.drawable.sol), WordType.LONG));
            words.add(new Word("Stol", context.getDrawable(R.drawable.stol), WordType.LONG));
            words.add(new Word("Ko", context.getDrawable(R.drawable.ko), WordType.LONG));
            //Korta uttal
            words.add(new Word("Korv", context.getDrawable(R.drawable.korv), WordType.SHORT));
            words.add(new Word("Klocka", context.getDrawable(R.drawable.klocka), WordType.SHORT));
            words.add(new Word("Bock", context.getDrawable(R.drawable.bock), WordType.SHORT));

            letterContainer.put(LetterID.O_LETTER,
                    new Letter("o", new SoundPlayer(context, LetterType.VOWEL, soundRawIDs), words));

            ///--------U--------
            soundRawIDs.clear();
            soundRawIDs.put(SoundType.LONG_VOWEL_SOUND, R.raw.vowel_u_long);
            soundRawIDs.put(SoundType.SHORT_VOWEL_SOUND, R.raw.vowel_u_short);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD1, R.raw.vowel_u_long_hus);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD2, R.raw.vowel_u_long_mus);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD3, R.raw.vowel_u_long_sju);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD1, R.raw.vowel_u_short_uggla);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD2, R.raw.vowel_u_short_mun);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD3, R.raw.vowel_u_short_buss);

            words.clear();
            //Långa uttal
            words.add(new Word("Hus", context.getDrawable(R.drawable.hus), WordType.LONG));
            words.add(new Word("Mus", context.getDrawable(R.drawable.mus), WordType.LONG));
            words.add(new Word("Sju", context.getDrawable(R.drawable.sju), WordType.LONG));
            //Korta uttal
            words.add(new Word("Uggla", context.getDrawable(R.drawable.uggla), WordType.SHORT));
            words.add(new Word("Mun", context.getDrawable(R.drawable.mun), WordType.SHORT));
            words.add(new Word("Buss", context.getDrawable(R.drawable.buss), WordType.SHORT));

            letterContainer.put(LetterID.U_LETTER,
                    new Letter("u", new SoundPlayer(context, LetterType.VOWEL, soundRawIDs), words));

            ///--------Y--------
            soundRawIDs.clear();
            soundRawIDs.put(SoundType.LONG_VOWEL_SOUND, R.raw.vowel_y_long);
            soundRawIDs.put(SoundType.SHORT_VOWEL_SOUND, R.raw.vowel_y_short);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD1, R.raw.vowel_y_long_myra);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD2, R.raw.vowel_y_long_fyr);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD3, R.raw.vowel_y_long_fyra);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD1, R.raw.vowel_y_short_yxa);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD2, R.raw.vowel_y_short_byxor);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD3, R.raw.vowel_y_short_kyckling);

            words.clear();
            //Långa uttal
            words.add(new Word("Myra", context.getDrawable(R.drawable.myra), WordType.LONG));
            words.add(new Word("Fyr", context.getDrawable(R.drawable.fyr), WordType.LONG));
            words.add(new Word("Fyra", context.getDrawable(R.drawable.fyra), WordType.LONG));
            //Korta uttal
            words.add(new Word("Yxa", context.getDrawable(R.drawable.yxa), WordType.SHORT));
            words.add(new Word("Byxor", context.getDrawable(R.drawable.byxor), WordType.SHORT));
            words.add(new Word("Kyckling", context.getDrawable(R.drawable.kyckling), WordType.SHORT));

            letterContainer.put(LetterID.Y_LETTER,
                    new Letter("y", new SoundPlayer(context, LetterType.VOWEL, soundRawIDs), words));

            ///--------Å--------
            soundRawIDs.clear();
            soundRawIDs.put(SoundType.LONG_VOWEL_SOUND, R.raw.vowel_ao_long);
            soundRawIDs.put(SoundType.SHORT_VOWEL_SOUND, R.raw.vowel_ao_short);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD1, R.raw.vowel_ao_long_asna);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD2, R.raw.vowel_ao_long_al);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD3, R.raw.vowel_ao_long_tva);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD1, R.raw.vowel_ao_short_tang);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD2, R.raw.vowel_ao_short_atta);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD3, R.raw.vowel_ao_short_ratta);

            words.clear();
            //Långa uttal
            words.add(new Word("Åsna", context.getDrawable(R.drawable.asna), WordType.LONG));
            words.add(new Word("Ål", context.getDrawable(R.drawable.al), WordType.LONG));
            words.add(new Word("Två", context.getDrawable(R.drawable.tva), WordType.LONG));
            //Korta uttal
            words.add(new Word("Tång", context.getDrawable(R.drawable.tang), WordType.SHORT));
            words.add(new Word("Åtta", context.getDrawable(R.drawable.atta), WordType.SHORT));
            words.add(new Word("Råtta", context.getDrawable(R.drawable.ratta), WordType.SHORT));

            letterContainer.put(LetterID.Å_LETTER,
                    new Letter("å", new SoundPlayer(context, LetterType.VOWEL, soundRawIDs), words));

            ///--------Ä--------
            soundRawIDs.clear();
            soundRawIDs.put(SoundType.LONG_VOWEL_SOUND, R.raw.vowel_ae_long);
            soundRawIDs.put(SoundType.SHORT_VOWEL_SOUND, R.raw.vowel_ae_short);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD1, R.raw.vowel_ae_long_trad);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD2, R.raw.vowel_ae_long_raka);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD3, R.raw.vowel_ae_long_nasa);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD1, R.raw.vowel_ae_short_agg);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD2, R.raw.vowel_ae_short_hjarta);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD3, R.raw.vowel_ae_short_talt);

            words.clear();
            //Långa uttal
            words.add(new Word("Träd", context.getDrawable(R.drawable.trad), WordType.LONG));
            words.add(new Word("Räka", context.getDrawable(R.drawable.raka), WordType.LONG));
            words.add(new Word("Näsa", context.getDrawable(R.drawable.nasa), WordType.LONG));
            //Korta uttal
            words.add(new Word("Ägg", context.getDrawable(R.drawable.agg), WordType.SHORT));
            words.add(new Word("Hjärta", context.getDrawable(R.drawable.hjarta), WordType.SHORT));
            words.add(new Word("Tält", context.getDrawable(R.drawable.talt), WordType.SHORT));

            letterContainer.put(LetterID.Ä_LETTER,
                    new Letter("ä", new SoundPlayer(context, LetterType.VOWEL, soundRawIDs), words));

            ///--------Ö--------
            soundRawIDs.clear();
            soundRawIDs.put(SoundType.LONG_VOWEL_SOUND, R.raw.vowel_oe_long);
            soundRawIDs.put(SoundType.SHORT_VOWEL_SOUND, R.raw.vowel_oe_short);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD1, R.raw.vowel_oe_long_oga);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD2, R.raw.vowel_oe_long_ora);
            soundRawIDs.put(SoundType.LONG_VOWEL_WORD3, R.raw.vowel_oe_long_smor);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD1, R.raw.vowel_oe_short_fonster);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD2, R.raw.vowel_oe_short_dorr);
            soundRawIDs.put(SoundType.SHORT_VOWEL_WORD3, R.raw.vowel_oe_short_kott);

            words.clear();
            //Långa uttal
            words.add(new Word("Öga", context.getDrawable(R.drawable.oga), WordType.LONG));
            words.add(new Word("Öra", context.getDrawable(R.drawable.ora), WordType.LONG));
            words.add(new Word("Smör", context.getDrawable(R.drawable.smor), WordType.LONG));
            //Korta uttal
            words.add(new Word("Fönster", context.getDrawable(R.drawable.fonster), WordType.SHORT));
            words.add(new Word("Dörr", context.getDrawable(R.drawable.dorr), WordType.SHORT));
            words.add(new Word("Kött", context.getDrawable(R.drawable.kott), WordType.SHORT));

            letterContainer.put(LetterID.Ö_LETTER,
                    new Letter("ö", new SoundPlayer(context, LetterType.VOWEL, soundRawIDs), words));
        } else {
            //do nothing
        }
    }

    public Letter getLetter(LetterID id){
        return letterContainer.get(id);
    }

}
