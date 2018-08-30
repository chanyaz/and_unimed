package com.google.android.gms.internal.ads;

import java.util.Map.Entry;

final class yn<K> implements Entry<K, Object> {
    private Entry<K, yl> a;

    private yn(Entry<K, yl> entry) {
        this.a = entry;
    }

    public final yl a() {
        return (yl) this.a.getValue();
    }

    public final K getKey() {
        return this.a.getKey();
    }

    public final Object getValue() {
        return ((yl) this.a.getValue()) == null ? null : yl.a();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzbcu) {
            return ((yl) this.a.getValue()).a((zzbcu) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
