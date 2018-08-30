package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.n;
import com.google.common.base.s;
import com.google.common.base.t;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Maps {
    static final n a = bb.a.c("=");

    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(@Nullable K k, @Nullable V1 v1);
    }

    private Maps() {
    }

    static <K> Function<Entry<K, ?>, K> a() {
        return gj.KEY;
    }

    static <K> Predicate<Entry<K, ?>> a(Predicate<? super K> predicate) {
        return t.a(predicate, a());
    }

    static <K, V> jl<V> a(final jl<Entry<K, V>> jlVar) {
        return new jl<V>() {
            public boolean hasNext() {
                return jlVar.hasNext();
            }

            public V next() {
                return ((Entry) jlVar.next()).getValue();
            }
        };
    }

    static <V> V a(Map<?, V> map, @Nullable Object obj) {
        V v = null;
        s.a((Object) map);
        try {
            return map.get(obj);
        } catch (ClassCastException e) {
            return v;
        } catch (NullPointerException e2) {
            return v;
        }
    }

    static String a(Map<?, ?> map) {
        StringBuilder append = bb.a(map.size()).append('{');
        a.a(append, (Map) map);
        return append.append('}').toString();
    }

    public static <K, V> HashMap<K, V> a(int i) {
        return new HashMap(b(i));
    }

    static <K, V> Iterator<K> a(Iterator<Entry<K, V>> it) {
        return er.a((Iterator) it, a());
    }

    static <K, V> Iterator<Entry<K, V>> a(Set<K> set, final Function<? super K, V> function) {
        return new jf<K, Entry<K, V>>(set.iterator()) {
            /* renamed from: b */
            Entry<K, V> a(K k) {
                return Maps.a((Object) k, function.apply(k));
            }
        };
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Entry<K, V> a(@Nullable K k, @Nullable V v) {
        return new cz(k, v);
    }

    static <K, V> Entry<K, V> a(final Entry<? extends K, ? extends V> entry) {
        s.a((Object) entry);
        return new ad<K, V>() {
            public K getKey() {
                return entry.getKey();
            }

            public V getValue() {
                return entry.getValue();
            }
        };
    }

    static <K, V> boolean a(Collection<Entry<K, V>> collection, Object obj) {
        return !(obj instanceof Entry) ? false : collection.contains(a((Entry) obj));
    }

    static int b(int i) {
        if (i >= 3) {
            return i < 1073741824 ? (i / 3) + i : MoPubClientPositioning.NO_REPEAT;
        } else {
            ba.a(i, "expectedSize");
            return i + 1;
        }
    }

    static <V> Function<Entry<?, V>, V> b() {
        return gj.VALUE;
    }

    static <V> Predicate<Entry<?, V>> b(Predicate<? super V> predicate) {
        return t.a(predicate, b());
    }

    @Nullable
    static <K> K b(@Nullable Entry<K, ?> entry) {
        return entry == null ? null : entry.getKey();
    }

    static <K, V> Iterator<V> b(Iterator<Entry<K, V>> it) {
        return er.a((Iterator) it, b());
    }

    static boolean b(Map<?, ?> map, Object obj) {
        boolean z = false;
        s.a((Object) map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException e) {
            return z;
        } catch (NullPointerException e2) {
            return z;
        }
    }

    static <V> V c(Map<?, V> map, Object obj) {
        V v = null;
        s.a((Object) map);
        try {
            return map.remove(obj);
        } catch (ClassCastException e) {
            return v;
        } catch (NullPointerException e2) {
            return v;
        }
    }

    public static <K, V> HashMap<K, V> c() {
        return new HashMap();
    }

    public static <K, V> LinkedHashMap<K, V> d() {
        return new LinkedHashMap();
    }

    static boolean d(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return map.entrySet().equals(((Map) obj).entrySet());
    }
}
