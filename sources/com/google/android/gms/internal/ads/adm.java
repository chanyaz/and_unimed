package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class adm extends aca<Integer, Long> {
    public Long a;
    public Long b;

    public adm(String str) {
        a(str);
    }

    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap();
        hashMap.put(Integer.valueOf(0), this.a);
        hashMap.put(Integer.valueOf(1), this.b);
        return hashMap;
    }

    protected final void a(String str) {
        HashMap b = aca.b(str);
        if (b != null) {
            this.a = (Long) b.get(Integer.valueOf(0));
            this.b = (Long) b.get(Integer.valueOf(1));
        }
    }
}
