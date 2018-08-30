package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class d implements NetworkExtras {
    private final HashMap<String, Object> a = new HashMap();

    public final Object a(String str) {
        return this.a.get(str);
    }
}
