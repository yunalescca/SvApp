package com.example.yunalescca.swedishpronunciations;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by tove on 2016-12-26.
 */

public class LetterGridItem extends TextView {

    public LetterGridItem(Context context) {
        super(context);
    }

    public LetterGridItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LetterGridItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
