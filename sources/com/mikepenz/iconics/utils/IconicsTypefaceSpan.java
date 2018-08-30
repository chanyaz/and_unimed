package com.mikepenz.iconics.utils;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class IconicsTypefaceSpan extends TypefaceSpan {
    private final Typeface a;

    public IconicsTypefaceSpan(String str, Typeface typeface) {
        super(str);
        this.a = typeface;
    }

    private static void a(Paint paint, Typeface typeface) {
        Typeface typeface2 = paint.getTypeface();
        int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (typeface.getStyle() ^ -1);
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }

    public void updateDrawState(TextPaint textPaint) {
        a(textPaint, this.a);
    }

    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint, this.a);
    }
}
