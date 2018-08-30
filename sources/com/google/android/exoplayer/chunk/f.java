package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.util.b;

public class f {
    public final String a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final float f;
    public final int g;
    public final int h;
    public final String i;
    public final String j;

    public f(String str, String str2, int i, int i2, float f, int i3, int i4, int i5) {
        this(str, str2, i, i2, f, i3, i4, i5, null);
    }

    public f(String str, String str2, int i, int i2, float f, int i3, int i4, int i5, String str3) {
        this(str, str2, i, i2, f, i3, i4, i5, str3, null);
    }

    public f(String str, String str2, int i, int i2, float f, int i3, int i4, int i5, String str3, String str4) {
        this.a = (String) b.a((Object) str);
        this.b = str2;
        this.d = i;
        this.e = i2;
        this.f = f;
        this.g = i3;
        this.h = i4;
        this.c = i5;
        this.j = str3;
        this.i = str4;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : (obj == null || getClass() != obj.getClass()) ? false : ((f) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
