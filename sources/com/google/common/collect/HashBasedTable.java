package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
public class HashBasedTable<R, C, V> extends il<R, C, V> {
    private static final long serialVersionUID = 0;

    public boolean contains(@Nullable Object obj, @Nullable Object obj2) {
        return super.contains(obj, obj2);
    }

    public boolean containsColumn(@Nullable Object obj) {
        return super.containsColumn(obj);
    }

    public boolean containsRow(@Nullable Object obj) {
        return super.containsRow(obj);
    }

    public boolean containsValue(@Nullable Object obj) {
        return super.containsValue(obj);
    }

    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public V get(@Nullable Object obj, @Nullable Object obj2) {
        return super.get(obj, obj2);
    }

    public V remove(@Nullable Object obj, @Nullable Object obj2) {
        return super.remove(obj, obj2);
    }
}
