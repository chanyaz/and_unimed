package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class adc extends aca<Integer, Long> {
    public long a;
    public long b;

    public adc() {
        this.a = -1;
        this.b = -1;
    }

    public adc(String str) {
        this();
        a(str);
    }

    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), Long.valueOf(this.a));
        hashMap.put(Integer.valueOf(1), Long.valueOf(this.b));
        return hashMap;
    }

    protected final void a(String str) {
        HashMap b = aca.b(str);
        if (b != null) {
            this.a = ((Long) b.get(Integer.valueOf(0))).longValue();
            this.b = ((Long) b.get(Integer.valueOf(1))).longValue();
        }
    }
}
