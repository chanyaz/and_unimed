package com.google.android.gms.internal.ads;

import java.util.List;

final class ar implements zzank<List<ann>, anj> {
    private final /* synthetic */ String a;
    private final /* synthetic */ Integer b;
    private final /* synthetic */ Integer c;
    private final /* synthetic */ int d;
    private final /* synthetic */ int e;
    private final /* synthetic */ int f;
    private final /* synthetic */ int g;
    private final /* synthetic */ boolean h;

    ar(am amVar, String str, Integer num, Integer num2, int i, int i2, int i3, int i4, boolean z) {
        this.a = str;
        this.b = num;
        this.c = num2;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = z;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Integer num = null;
        List list = (List) obj;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String str = this.a;
        Integer num2 = this.b;
        Integer num3 = this.c;
        if (this.d > 0) {
            num = Integer.valueOf(this.d);
        }
        return new anj(str, list, num2, num3, num, this.e + this.f, this.g, this.h);
    }
}
