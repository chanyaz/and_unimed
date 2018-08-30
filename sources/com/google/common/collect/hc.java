package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;

@GwtCompatible(emulated = true)
public final class hc {
    static final Object[] a = new Object[0];

    private hc() {
    }

    static Object a(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i);
    }

    private static Object[] a(Iterable<?> iterable, Object[] objArr) {
        int i = 0;
        for (Object obj : iterable) {
            int i2 = i + 1;
            objArr[i] = obj;
            i = i2;
        }
        return objArr;
    }

    static <T> T[] a(Collection<?> collection, T[] tArr) {
        Object[] tArr2;
        int size = collection.size();
        if (tArr2.length < size) {
            tArr2 = a((Object[]) tArr2, size);
        }
        a((Iterable) collection, tArr2);
        if (tArr2.length > size) {
            tArr2[size] = null;
        }
        return tArr2;
    }

    static Object[] a(Object... objArr) {
        return c(objArr, objArr.length);
    }

    public static <T> T[] a(T[] tArr, int i) {
        return he.a(tArr, i);
    }

    static <T> T[] b(T[] tArr, int i) {
        Object a = a((Object[]) tArr, i);
        System.arraycopy(tArr, 0, a, 0, Math.min(tArr.length, i));
        return a;
    }

    static Object[] c(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            a(objArr[i2], i2);
        }
        return objArr;
    }
}
