package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class acc extends aca<Integer, Object> {
    public String a;
    public long b;
    public String c;
    public String d;
    public String e;

    public acc() {
        this.a = "E";
        this.b = -1;
        this.c = "E";
        this.d = "E";
        this.e = "E";
    }

    public acc(String str) {
        this();
        a(str);
    }

    protected final HashMap<Integer, Object> a() {
        HashMap<Integer, Object> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.a);
        hashMap.put(Integer.valueOf(4), this.e);
        hashMap.put(Integer.valueOf(3), this.d);
        hashMap.put(Integer.valueOf(2), this.c);
        hashMap.put(Integer.valueOf(1), Long.valueOf(this.b));
        return hashMap;
    }

    protected final void a(String str) {
        HashMap b = aca.b(str);
        if (b != null) {
            this.a = b.get(Integer.valueOf(0)) == null ? "E" : (String) b.get(Integer.valueOf(0));
            this.b = b.get(Integer.valueOf(1)) == null ? -1 : ((Long) b.get(Integer.valueOf(1))).longValue();
            this.c = b.get(Integer.valueOf(2)) == null ? "E" : (String) b.get(Integer.valueOf(2));
            this.d = b.get(Integer.valueOf(3)) == null ? "E" : (String) b.get(Integer.valueOf(3));
            this.e = b.get(Integer.valueOf(4)) == null ? "E" : (String) b.get(Integer.valueOf(4));
        }
    }
}
