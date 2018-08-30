package com.puzzlersworld.android.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomFontTextView extends TextView {
    public CustomFontTextView(Context context) {
        super(context);
        a(context);
    }

    public CustomFontTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CustomFontTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        Typeface a = e.a(null, context);
        if (a != null) {
            setTypeface(a);
        }
    }
}
