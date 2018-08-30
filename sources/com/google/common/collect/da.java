package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class da<K extends Enum<K>, V> extends ImmutableMap<K, V> {
    private final transient EnumMap<K, V> a;

    private da(EnumMap<K, V> enumMap) {
        this.a = enumMap;
        s.a(!enumMap.isEmpty());
    }

    /* synthetic */ da(EnumMap enumMap, AnonymousClass1 anonymousClass1) {
        this(enumMap);
    }

    static <K extends Enum<K>, V> ImmutableMap<K, V> a(EnumMap<K, V> enumMap) {
        switch (enumMap.size()) {
            case 0:
                return ImmutableMap.i();
            case 1:
                Entry entry = (Entry) eq.b(enumMap.entrySet());
                return ImmutableMap.b(entry.getKey(), entry.getValue());
            default:
                return new da(enumMap);
        }
    }

    ImmutableSet<K> a() {
        return new ImmutableSet<K>() {
            boolean c() {
                return true;
            }

            public boolean contains(Object obj) {
                return da.this.a.containsKey(obj);
            }

            /* renamed from: h_ */
            public jl<K> iterator() {
                return er.a(da.this.a.keySet().iterator());
            }

            public int size() {
                return da.this.size();
            }
        };
    }

    ImmutableSet<Entry<K, V>> c() {
        return new dm<K, V>() {
            ImmutableMap<K, V> e() {
                return da.this;
            }

            /* renamed from: h_ */
            public jl<Entry<K, V>> iterator() {
                return new jl<Entry<K, V>>() {
                    private final Iterator<Entry<K, V>> b = da.this.a.entrySet().iterator();

                    /* renamed from: a */
                    public Entry<K, V> next() {
                        Entry entry = (Entry) this.b.next();
                        return Maps.a(entry.getKey(), entry.getValue());
                    }

                    public boolean hasNext() {
                        return this.b.hasNext();
                    }
                };
            }
        };
    }

    public boolean containsKey(@Nullable Object obj) {
        return this.a.containsKey(obj);
    }

    boolean e() {
        return false;
    }

    public V get(Object obj) {
        return this.a.get(obj);
    }

    public int size() {
        return this.a.size();
    }

    Object writeReplace() {
        return new db(this.a);
    }
}
