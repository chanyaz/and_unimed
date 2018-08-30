package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

abstract class au<K, V> extends gl<K, V> {
    private final ImmutableMap<K, Integer> a;

    private au(ImmutableMap<K, Integer> immutableMap) {
        this.a = immutableMap;
    }

    K a(int i) {
        return this.a.keySet().b().get(i);
    }

    @Nullable
    abstract V a(int i, V v);

    protected Set<Entry<K, V>> a() {
        return new gk<K, V>() {
            Map<K, V> a() {
                return au.this;
            }

            public Iterator<Entry<K, V>> iterator() {
                return new f<Entry<K, V>>(size()) {
                    /* renamed from: b */
                    protected Entry<K, V> a(final int i) {
                        return new ad<K, V>() {
                            public K getKey() {
                                return au.this.a(i);
                            }

                            public V getValue() {
                                return au.this.b(i);
                            }

                            public V setValue(V v) {
                                return au.this.a(i, v);
                            }
                        };
                    }
                };
            }
        };
    }

    @Nullable
    abstract V b(int i);

    abstract String b();

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(@Nullable Object obj) {
        return this.a.containsKey(obj);
    }

    public V get(@Nullable Object obj) {
        Integer num = (Integer) this.a.get(obj);
        return num == null ? null : b(num.intValue());
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Set<K> keySet() {
        return this.a.keySet();
    }

    public V put(K k, V v) {
        Integer num = (Integer) this.a.get(k);
        if (num != null) {
            return a(num.intValue(), v);
        }
        throw new IllegalArgumentException(b() + " " + k + " not in " + this.a.keySet());
    }

    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.a.size();
    }
}
