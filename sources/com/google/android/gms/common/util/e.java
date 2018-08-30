package com.google.android.gms.common.util;

import android.support.v4.util.a;
import android.support.v4.util.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class e {
    private e() {
    }

    @Deprecated
    public static <T> List<T> a() {
        return Collections.emptyList();
    }

    @Deprecated
    public static <T> List<T> a(T t) {
        return Collections.singletonList(t);
    }

    @Deprecated
    public static <T> List<T> a(T... tArr) {
        switch (tArr.length) {
            case 0:
                return a();
            case 1:
                return a(tArr[0]);
            default:
                return Collections.unmodifiableList(Arrays.asList(tArr));
        }
    }

    private static <K, V> Map<K, V> a(int i, boolean z, K[] kArr, V[] vArr) {
        Map b = b(i, z);
        a(b, (Object[]) kArr, (Object[]) vArr);
        return b;
    }

    public static <K, V> Map<K, V> a(K k, V v, K k2, V v2, K k3, V v3) {
        Map b = b(3, false);
        b.put(k, v);
        b.put(k2, v2);
        b.put(k3, v3);
        return Collections.unmodifiableMap(b);
    }

    public static <K, V> Map<K, V> a(K[] kArr, V[] vArr) {
        b((Object[]) kArr, (Object[]) vArr);
        switch (kArr.length) {
            case 0:
                return c();
            case 1:
                return b(kArr[0], vArr[0]);
            default:
                return Collections.unmodifiableMap(a(kArr.length, false, (Object[]) kArr, (Object[]) vArr));
        }
    }

    private static <T> Set<T> a(int i, boolean z) {
        return i <= (z ? 128 : 256) ? new b(i) : new HashSet(i, z ? 0.75f : 1.0f);
    }

    private static <T> Set<T> a(int i, boolean z, T[] tArr) {
        Object a = a(i, z);
        Collections.addAll(a, tArr);
        return a;
    }

    @Deprecated
    public static <T> Set<T> a(T t, T t2) {
        Set a = a(2, false);
        a.add(t);
        a.add(t2);
        return Collections.unmodifiableSet(a);
    }

    @Deprecated
    public static <T> Set<T> a(T t, T t2, T t3) {
        Set a = a(3, false);
        a.add(t);
        a.add(t2);
        a.add(t3);
        return Collections.unmodifiableSet(a);
    }

    @Deprecated
    public static <T> Set<T> a(T t, T t2, T t3, T t4) {
        Set a = a(4, false);
        a.add(t);
        a.add(t2);
        a.add(t3);
        a.add(t4);
        return Collections.unmodifiableSet(a);
    }

    private static <K, V> void a(Map<K, V> map, K[] kArr, V[] vArr) {
        for (int i = 0; i < kArr.length; i++) {
            map.put(kArr[i], vArr[i]);
        }
    }

    private static <K, V> Map<K, V> b(int i, boolean z) {
        return i <= (z ? 128 : 256) ? new a(i) : new HashMap(i, z ? 0.75f : 1.0f);
    }

    public static <K, V> Map<K, V> b(K k, V v) {
        return Collections.singletonMap(k, v);
    }

    @Deprecated
    public static <T> Set<T> b() {
        return Collections.emptySet();
    }

    @Deprecated
    public static <T> Set<T> b(T t) {
        return Collections.singleton(t);
    }

    @Deprecated
    public static <T> Set<T> b(T... tArr) {
        switch (tArr.length) {
            case 0:
                return b();
            case 1:
                return b(tArr[0]);
            case 2:
                return a(tArr[0], tArr[1]);
            case 3:
                return a(tArr[0], tArr[1], tArr[2]);
            case 4:
                return a(tArr[0], tArr[1], tArr[2], tArr[3]);
            default:
                return Collections.unmodifiableSet(a(tArr.length, false, (Object[]) tArr));
        }
    }

    private static <K, V> void b(K[] kArr, V[] vArr) {
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + vArr.length);
        }
    }

    public static <K, V> Map<K, V> c() {
        return Collections.emptyMap();
    }
}
