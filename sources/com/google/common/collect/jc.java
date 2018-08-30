package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.collect.Table.Cell;
import java.util.Collections;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public final class jc {
    private static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> a = new Function<Map<Object, Object>, Map<Object, Object>>() {
        /* renamed from: a */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    };

    private jc() {
    }

    public static <R, C, V> Cell<R, C, V> a(@Nullable R r, @Nullable C c, @Nullable V v) {
        return new je(r, c, v);
    }

    static boolean a(Table<?, ?, ?> table, @Nullable Object obj) {
        if (obj == table) {
            return true;
        }
        if (!(obj instanceof Table)) {
            return false;
        }
        return table.cellSet().equals(((Table) obj).cellSet());
    }
}
