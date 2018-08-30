package com.google.android.gms.internal.ads;

@zzadh
public final class op {
    public final int a;
    public final int b;
    private final int c;

    private op(int i, int i2, int i3) {
        this.c = i;
        this.b = i2;
        this.a = i3;
    }

    public static op a() {
        return new op(0, 0, 0);
    }

    public static op a(int i, int i2) {
        return new op(1, i, i2);
    }

    public static op a(zzjn zzjn) {
        return zzjn.d ? new op(3, 0, 0) : zzjn.i ? new op(2, 0, 0) : zzjn.h ? a() : a(zzjn.f, zzjn.c);
    }

    public static op b() {
        return new op(4, 0, 0);
    }

    public final boolean c() {
        return this.c == 2;
    }

    public final boolean d() {
        return this.c == 3;
    }

    public final boolean e() {
        return this.c == 0;
    }

    public final boolean f() {
        return this.c == 4;
    }
}
