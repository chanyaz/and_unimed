package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class dm<K, V> extends ImmutableSet<Entry<K, V>> {
    dm() {
    }

    boolean c() {
        return e().e();
    }

    public boolean contains(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object obj2 = e().get(entry.getKey());
        return obj2 != null && obj2.equals(entry.getValue());
    }

    abstract ImmutableMap<K, V> e();

    public int size() {
        return e().size();
    }

    @GwtIncompatible("serialization")
    Object writeReplace() {
        return new dn(e());
    }
}
