package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.m;
import com.google.common.base.s;
import com.google.common.base.t;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible
public final class bb {
    static final m a = m.a(", ").b("null");

    private bb() {
    }

    static String a(final Collection<?> collection) {
        StringBuilder append = a(collection.size()).append('[');
        a.a(append, eq.a((Iterable) collection, new Function<Object, Object>() {
            public Object apply(Object obj) {
                return obj == collection ? "(this Collection)" : obj;
            }
        }));
        return append.append(']').toString();
    }

    static StringBuilder a(int i) {
        ba.a(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824));
    }

    static <T> Collection<T> a(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    static boolean a(Collection<?> collection, @Nullable Object obj) {
        boolean z = false;
        s.a((Object) collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException e) {
            return z;
        } catch (NullPointerException e2) {
            return z;
        }
    }

    static boolean a(Collection<?> collection, Collection<?> collection2) {
        return eq.b(collection2, t.a((Collection) collection));
    }

    static boolean b(Collection<?> collection, @Nullable Object obj) {
        boolean z = false;
        s.a((Object) collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException e) {
            return z;
        } catch (NullPointerException e2) {
            return z;
        }
    }
}
