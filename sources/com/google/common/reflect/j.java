package com.google.common.reflect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.hd;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.Nullable;

abstract class j<K> {
    static final j<TypeToken<?>> a = new j<TypeToken<?>>() {
        /* renamed from: a */
        Class<?> b(TypeToken<?> typeToken) {
            return typeToken.b();
        }

        /* renamed from: b */
        Iterable<? extends TypeToken<?>> c(TypeToken<?> typeToken) {
            return typeToken.d();
        }

        @Nullable
        /* renamed from: c */
        TypeToken<?> d(TypeToken<?> typeToken) {
            return typeToken.c();
        }
    };
    static final j<Class<?>> b = new j<Class<?>>() {
        /* renamed from: a */
        Class<?> b(Class<?> cls) {
            return cls;
        }

        /* renamed from: b */
        Iterable<? extends Class<?>> c(Class<?> cls) {
            return Arrays.asList(cls.getInterfaces());
        }

        @Nullable
        /* renamed from: c */
        Class<?> d(Class<?> cls) {
            return cls.getSuperclass();
        }
    };

    private j() {
    }

    /* synthetic */ j(com.google.common.reflect.TypeToken.AnonymousClass1 anonymousClass1) {
        this();
    }

    private int a(K k, Map<? super K, Integer> map) {
        Integer num = (Integer) map.get(this);
        if (num != null) {
            return num.intValue();
        }
        int i = b(k).isInterface() ? 1 : 0;
        for (Object a : c(k)) {
            i = Math.max(i, a(a, (Map) map));
        }
        Object d = d(k);
        if (d != null) {
            i = Math.max(i, a(d, (Map) map));
        }
        map.put(k, Integer.valueOf(i + 1));
        return i + 1;
    }

    private static <K, V> ImmutableList<K> a(final Map<K, V> map, final Comparator<? super V> comparator) {
        return new hd<K>() {
            public int compare(K k, K k2) {
                return comparator.compare(map.get(k), map.get(k2));
            }
        }.a(map.keySet());
    }

    ImmutableList<K> a(Iterable<? extends K> iterable) {
        Map c = Maps.c();
        for (Object a : iterable) {
            a(a, c);
        }
        return a(c, hd.b().a());
    }

    final ImmutableList<K> a(K k) {
        return a(ImmutableList.a((Object) k));
    }

    abstract Class<?> b(K k);

    abstract Iterable<? extends K> c(K k);

    @Nullable
    abstract K d(K k);
}
