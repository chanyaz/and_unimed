package com.google.android.exoplayer.text;

import android.text.Layout.Alignment;

public class b {
    public final CharSequence a;
    public final int b;
    public final int c;
    public final Alignment d;
    public final int e;

    public b() {
        this(null);
    }

    public b(CharSequence charSequence) {
        this(charSequence, -1, -1, null, -1);
    }

    public b(CharSequence charSequence, int i, int i2, Alignment alignment, int i3) {
        this.a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = alignment;
        this.e = i3;
    }
}
