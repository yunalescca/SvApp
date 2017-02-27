package com.example.yunalescca.swedishpronunciations.controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.yunalescca.swedishpronunciations.LetterFragment;
import com.example.yunalescca.swedishpronunciations.services.LetterManager;

/**
 * Created by tove on 2016-09-25.
 */

public class LetterPagerAdapter extends FragmentStatePagerAdapter {

    private int letterType;

    public LetterPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new LetterFragment();
        Bundle args = new Bundle();
        args.putInt(LetterFragment.ARG_LETTER_POSITION, i);
        args.putInt(LetterFragment.ARG_LETTER_TYPE, letterType);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {
        return LetterManager.getInstance().getLetters(letterType).size();
    }

    public void setLetterType(int type) {
        letterType = type;
    }
}