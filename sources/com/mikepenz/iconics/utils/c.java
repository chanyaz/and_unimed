package com.mikepenz.iconics.utils;

import android.text.ParcelableSpan;
import android.text.style.CharacterStyle;
import com.mikepenz.iconics.typeface.ITypeface;

public class c {
    public int a;
    public int b;
    public String c;
    public ITypeface d;
    public ParcelableSpan e;
    public CharacterStyle f;
    public int g = 33;

    public c(int i, int i2, ParcelableSpan parcelableSpan, int i3) {
        this.a = i;
        this.b = i2;
        this.e = parcelableSpan;
        this.g = i3;
    }

    public c(int i, int i2, CharacterStyle characterStyle, int i3) {
        this.a = i;
        this.b = i2;
        this.f = characterStyle;
        this.g = i3;
    }

    public c(int i, int i2, String str, ITypeface iTypeface) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = iTypeface;
    }
}
