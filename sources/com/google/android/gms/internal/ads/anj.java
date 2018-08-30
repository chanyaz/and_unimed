package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

@zzadh
public final class anj extends aon {
    private static final int a = Color.rgb(12, 174, 206);
    private static final int b;
    private static final int c;
    private static final int d = a;
    private final String e;
    private final List<ann> f = new ArrayList();
    private final List<zzpw> g = new ArrayList();
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final boolean m;

    static {
        int rgb = Color.rgb(204, 204, 204);
        b = rgb;
        c = rgb;
    }

    public anj(String str, List<ann> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.e = str;
        if (list != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= list.size()) {
                    break;
                }
                ann ann = (ann) list.get(i4);
                this.f.add(ann);
                this.g.add(ann);
                i3 = i4 + 1;
            }
        }
        this.h = num != null ? num.intValue() : c;
        this.i = num2 != null ? num2.intValue() : d;
        this.j = num3 != null ? num3.intValue() : 12;
        this.k = i;
        this.l = i2;
        this.m = z;
    }

    public final List<ann> a() {
        return this.f;
    }

    public final int b() {
        return this.h;
    }

    public final int c() {
        return this.i;
    }

    public final int d() {
        return this.j;
    }

    public final int e() {
        return this.k;
    }

    public final int f() {
        return this.l;
    }

    public final boolean g() {
        return this.m;
    }

    public final String getText() {
        return this.e;
    }

    public final List<zzpw> zzjr() {
        return this.g;
    }
}
