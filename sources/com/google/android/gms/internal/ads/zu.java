package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

final class zu extends aaa {
    private final /* synthetic */ zr a;

    private zu(zr zrVar) {
        this.a = zrVar;
        super(zrVar, null);
    }

    /* synthetic */ zu(zr zrVar, zs zsVar) {
        this(zrVar);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new zt(this.a, null);
    }
}
