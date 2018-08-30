package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class bq extends ImmutableBiMap<Object, Object> {
    static final bq a = new bq();

    private bq() {
    }

    /* renamed from: b */
    public ImmutableSet<Entry<Object, Object>> entrySet() {
        return ImmutableSet.g();
    }

    ImmutableSet<Entry<Object, Object>> c() {
        throw new AssertionError("should never be called");
    }

    /* renamed from: d */
    public ImmutableSet<Object> keySet() {
        return ImmutableSet.g();
    }

    boolean e() {
        return false;
    }

    public Object get(@Nullable Object obj) {
        return null;
    }

    /* renamed from: i_ */
    public ImmutableBiMap<Object, Object> inverse() {
        return this;
    }

    public boolean isEmpty() {
        return true;
    }

    Object readResolve() {
        return a;
    }

    public int size() {
        return 0;
    }
}
